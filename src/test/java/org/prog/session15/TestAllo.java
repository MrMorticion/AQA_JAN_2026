package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestAllo {

    private static final String HOME_URL = "https://allo.ua/";

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void myWebTest() {
        driver.get(HOME_URL);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchInput = webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.name("search")));
        searchInput.sendKeys("iphone");
        searchInput.sendKeys(Keys.ENTER);

        By productCardsLocator = By.xpath(
                "//div[contains(@class,'products-layout__item') or contains(@class,'product-card')]");
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(HOME_URL)));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productCardsLocator, 2));

        List<WebElement> products = driver.findElements(productCardsLocator);
        Assert.assertTrue(products.size() >= 3, "Less than 3 products were found.");

        int checkedProducts = 0;

        for (WebElement product : products) {
            if (checkedProducts == 3) {
                break;
            }

            List<WebElement> titleElements = product.findElements(By.xpath(
                    ".//a[contains(@class,'product-card__title')] | .//*[@itemprop='name']"));

            List<WebElement> priceElements = product.findElements(By.xpath(
                    ".//*[contains(@class,'sum') and not(contains(@class,'old'))]"
                            + " | .//*[contains(@class,'price-box__final-price')]"
                            + " | .//*[contains(@class,'product-card__price') and not(contains(@class,'old'))]"
                            + " | .//*[contains(@class,'v-pb__cur')]"));

            if (titleElements.isEmpty() || priceElements.isEmpty()) {
                continue;
            }

            String titleText = titleElements.get(0).getText();
            if ((titleText == null || titleText.isBlank()) && titleElements.get(0).getAttribute("title") != null) {
                titleText = titleElements.get(0).getAttribute("title");
            }

            String priceText = priceElements.get(0).getText();

            Assert.assertNotNull(titleText, "Title is null for product " + (checkedProducts + 1));
            Assert.assertFalse(titleText.isBlank(), "Title is blank for product " + (checkedProducts + 1));
            Assert.assertNotNull(priceText, "Price is null for product " + (checkedProducts + 1));
            Assert.assertFalse(priceText.isBlank(), "Price is blank for product " + (checkedProducts + 1));

            checkedProducts++;
        }

        Assert.assertEquals(checkedProducts, 3, "Could not find 3 products with title and price.");

        Assert.assertNotEquals(driver.getCurrentUrl(), HOME_URL, "Search results page did not open.");
        System.out.println("done!");
    }

    @Test
    public void myTestAllo() {
        myWebTest();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}