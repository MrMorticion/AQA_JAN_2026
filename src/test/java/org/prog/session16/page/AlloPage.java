package org.prog.session16.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlloPage {

    private static final String HOME_URL = "https://allo.ua/";

    private static final By SEARCH_INPUT = By.name("search");
    private static final By PRODUCT_CARDS = By.xpath(
            "//div[contains(@class,'products-layout__item') or contains(@class,'product-card')]");
    private static final By PRODUCT_TITLE = By.xpath(
            ".//a[contains(@class,'product-card__title')] | .//*[@itemprop='name']");
    private static final By PRODUCT_PRICE = By.xpath(
            ".//*[contains(@class,'sum') and not(contains(@class,'old'))]"
                    + " | .//*[contains(@class,'price-box__final-price')]"
                    + " | .//*[contains(@class,'product-card__price') and not(contains(@class,'old'))]"
                    + " | .//*[contains(@class,'v-pb__cur')]");

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void loadPage() {
        driver.get(HOME_URL);
    }

    public void searchFor(String searchText) {
        WebElement searchInput = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
    }

    public List<WebElement> waitForProductCards(int minimumProducts) {
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(HOME_URL)));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(PRODUCT_CARDS, minimumProducts));
        return driver.findElements(PRODUCT_CARDS);
    }

    public String getProductTitle(WebElement productCard) {
        List<WebElement> titleElements = productCard.findElements(PRODUCT_TITLE);
        if (titleElements.isEmpty()) {
            return null;
        }

        WebElement titleElement = titleElements.get(0);
        String titleText = titleElement.getText();
        if ((titleText == null || titleText.isBlank()) && titleElement.getAttribute("title") != null) {
            titleText = titleElement.getAttribute("title");
        }
        return titleText;
    }

    public String getProductPrice(WebElement productCard) {
        List<WebElement> priceElements = productCard.findElements(PRODUCT_PRICE);
        if (priceElements.isEmpty()) {
            return null;
        }
        return priceElements.get(0).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getHomeUrl() {
        return HOME_URL;
    }
}