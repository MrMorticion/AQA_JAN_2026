package org.prog.session14;

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

public class TestAllo {

    private static final String HOME_URL = "https://allo.ua/";

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    public void myWebTest() {
        driver.get(HOME_URL);
        WebElement element = driver.findElement(By.name("search"));
        element.sendKeys("iPhone 17");
        element.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(HOME_URL)));

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