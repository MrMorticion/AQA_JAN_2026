package org.prog.session16.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session16.page.AlloPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestAllo {

    private WebDriver driver;
    private AlloPage alloPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        alloPage = new AlloPage(driver);
    }

    public void myWebTest() {
        alloPage.loadPage();
        alloPage.searchFor("iphone");

        List<WebElement> products = alloPage.waitForProductCards(2);
        Assert.assertTrue(products.size() >= 3, "Less than 3 products were found.");

        int checkedProducts = 0;

        for (WebElement product : products) {
            if (checkedProducts == 3) {
                break;
            }

            String titleText = alloPage.getProductTitle(product);
            String priceText = alloPage.getProductPrice(product);

            if (titleText == null || titleText.isBlank() || priceText == null || priceText.isBlank()) {
                continue;
            }

            Assert.assertFalse(titleText.isBlank(), "Title is blank for product " + (checkedProducts + 1));
            Assert.assertFalse(priceText.isBlank(), "Price is blank for product " + (checkedProducts + 1));

            checkedProducts++;
        }

        Assert.assertEquals(checkedProducts, 3, "Could not find 3 products with title and price.");

        Assert.assertNotEquals(alloPage.getCurrentUrl(), alloPage.getHomeUrl(), "Search results page did not open.");
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