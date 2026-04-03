package org.prog.session16.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlloPageObjectTaskTest {

    private WebDriver driver;
    private AlloPageObject alloPageObject;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        alloPageObject = new AlloPageObject(driver);
    }

    @Test
    public void myTestAlloWithPageObject() {
        alloPageObject.loadPage();
        alloPageObject.searchFor("iphone");

        List<WebElement> products = alloPageObject.waitForProductCards(2);
        Assert.assertTrue(products.size() >= 3, "Less than 3 products were found.");

        int checkedProducts = 0;

        for (WebElement product : products) {
            if (checkedProducts == 3) {
                break;
            }

            String titleText = alloPageObject.getProductTitle(product);
            String priceText = alloPageObject.getProductPrice(product);

            if (titleText == null || titleText.isBlank() || priceText == null || priceText.isBlank()) {
                continue;
            }

            Assert.assertFalse(titleText.isBlank(), "Title is blank for product " + (checkedProducts + 1));
            Assert.assertFalse(priceText.isBlank(), "Price is blank for product " + (checkedProducts + 1));
            checkedProducts++;
        }

        Assert.assertEquals(checkedProducts, 3, "Could not find 3 products with title and price.");
        Assert.assertNotEquals(
                alloPageObject.getCurrentUrl(),
                alloPageObject.getHomeUrl(),
                "Search results page did not open.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

class AlloPageObject {

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

    AlloPageObject(WebDriver driver) {
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