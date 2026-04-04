package org.prog.session18;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.session19.DataHolder;
import org.testng.Assert;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.util.Optional;

public class AlloSteps {

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(20);
    private static final Duration SHORT_TIMEOUT = Duration.ofSeconds(3);

    public static WebDriver driver;

    @Given("I open Allo main page")
    public void openAlloMainPage() {
        driver.get("https://allo.ua/ua/");
    }

    @When("I accept Allo cookies if present")
    public void acceptAlloCookiesIfPresent() {
        List<By> cookieButtons = List.of(
                By.xpath("//button[contains(., 'Прийняти') or contains(., 'Принять') or contains(., 'Accept') or contains(., 'Погоджуюсь')]"),
                By.xpath("//a[contains(., 'Прийняти') or contains(., 'Accept')]")
        );

        for (By locator : cookieButtons) {
            for (WebElement element : driver.findElements(locator)) {
                if (!element.isDisplayed()) {
                    continue;
                }
                try {
                    new WebDriverWait(driver, SHORT_TIMEOUT)
                            .until(ExpectedConditions.elementToBeClickable(element))
                            .click();
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                }
                return;
            }
        }
    }

    @When("I search Allo for {string}")
    public void searchAlloFor(String query) {
        Optional<WebElement> searchInput = findSearchInput();
        if (searchInput.isPresent()) {
            WebElement input = searchInput.get();
            input.click();
            input.clear();
            input.sendKeys(query);
            input.sendKeys(Keys.ENTER);
            if (waitForPhones()) {
                return;
            }
        }

        driver.get("https://allo.ua/ua/catalogsearch/result/?q=" + URLEncoder.encode(query, StandardCharsets.UTF_8));
        if (waitForPhones()) {
            return;
        }

        if (query.toLowerCase(Locale.ROOT).contains("iphone")) {
            driver.get("https://allo.ua/ua/products/mobile/proizvoditel-apple/");
        }

        if (!waitForPhones()) {
            throw new TimeoutException("Allo search results were not loaded");
        }
    }

    @Then("I save first {int} Allo phone models and prices as {string}")
    public void saveFirstAlloPhoneModelsAndPrices(int amount, String alias) {
        List<Map<?, ?>> foundPhones = readPhoneCards(amount);
        Assert.assertEquals(foundPhones.size(), amount, "Unexpected number of phones found on Allo");
        DataHolder.data.put(alias, foundPhones);
    }

    private Optional<WebElement> findSearchInput() {
        List<By> searchInputs = List.of(
                By.cssSelector("input[type='search']"),
                By.cssSelector("input[name='q']"),
                By.cssSelector("input[name='search']"),
                By.xpath("//input[contains(@placeholder, 'Пошук') or contains(@placeholder, 'Search')]")
        );

        for (By locator : searchInputs) {
            try {
                WebElement element = new WebDriverWait(driver, SHORT_TIMEOUT)
                        .until(ExpectedConditions.visibilityOfElementLocated(locator));
                return Optional.of(element);
            } catch (Exception ignored) {
            }
        }

        return Optional.empty();
    }

    private boolean waitForPhones() {
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT).until(d -> !extractPhones(3).isEmpty());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    private List<Map<?, ?>> readPhoneCards(int amount) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(d -> !extractPhones(amount).isEmpty());
        List<Map<?, ?>> phones = extractPhones(amount);
        if (phones.size() < amount) {
            throw new NoSuchElementException("Expected at least " + amount + " phones, but found " + phones.size());
        }
        return phones;
    }

    @SuppressWarnings("unchecked")
    private List<Map<?, ?>> extractPhones(int limit) {
        Object rawResponse = ((JavascriptExecutor) driver).executeScript("""
                const limit = arguments[0];
                const normalize = value => (value || '').replace(/\\s+/g, ' ').trim();
                const parsePrice = text => {
                    const cleaned = normalize(text).replace(/\\u00a0/g, ' ');
                    const match = cleaned.match(/(\\d[\\d\\s]{2,})\\s*(?:₴|грн)/i);
                    if (!match) {
                        return null;
                    }
                    return parseInt(match[1].replace(/\\s+/g, ''), 10);
                };
                const parseJsonProducts = () => {
                    const products = [];
                    const scripts = Array.from(document.querySelectorAll('script[type="application/ld+json"]'));
                    for (const script of scripts) {
                        try {
                            const parsed = JSON.parse(script.textContent);
                            const items = Array.isArray(parsed) ? parsed : [parsed];
                            for (const item of items) {
                                if (!item) {
                                    continue;
                                }
                                const list = Array.isArray(item['@graph']) ? item['@graph'] : [item];
                                for (const graphItem of list) {
                                    const name = normalize(graphItem && graphItem.name);
                                    const rawPrice = graphItem && graphItem.offers && graphItem.offers.price;
                                    const price = Number(rawPrice);
                                    if (name && /iphone/i.test(name) && Number.isFinite(price) && price > 0) {
                                        products.push({model: name, price: Math.round(price)});
                                    }
                                }
                            }
                        } catch (e) {
                        }
                    }
                    return products;
                };
                const cards = [];
                const seen = new Set();
                const candidates = Array.from(document.querySelectorAll(
                    'a[href*="/products/mobile/"], a[href*="iphone" i], [data-product-id] a, [class*="product-card"] a, [class*="products-layout__item"] a, article a'
                ));
                for (const candidate of candidates) {
                    const link = candidate.tagName === 'A' ? candidate : candidate.querySelector('a');
                    if (!link) {
                        continue;
                    }
                    let model = normalize(link.textContent || link.getAttribute('title'));
                    if (!model) {
                        const image = link.querySelector('img');
                        model = normalize(image ? image.getAttribute('alt') : '');
                    }
                    if (!model || !/iphone/i.test(model)) {
                        continue;
                    }
                    const container = link.closest('article, li, [data-product-id], [class*="product-card"], [class*="item-card"], div');
                    const price = parsePrice(container ? container.innerText : link.innerText);
                    if (!price) {
                        continue;
                    }
                    const key = model.toLowerCase();
                    if (seen.has(key)) {
                        continue;
                    }
                    seen.add(key);
                    cards.push({model: model, price: price});
                    if (cards.length === limit) {
                        break;
                    }
                }
                if (cards.length < limit) {
                    for (const product of parseJsonProducts()) {
                        const key = product.model.toLowerCase();
                        if (seen.has(key)) {
                            continue;
                        }
                        seen.add(key);
                        cards.push(product);
                        if (cards.length === limit) {
                            break;
                        }
                    }
                }
                return cards;
                """, limit);

        if (!(rawResponse instanceof List<?> rawList)) {
            return new ArrayList<>();
        }
        List<Map<?, ?>> phones = new ArrayList<>();
        for (Object item : rawList) {
            if (item instanceof Map<?, ?> map) {
                phones.add(map);
            }
        }
        return phones;
    }
}