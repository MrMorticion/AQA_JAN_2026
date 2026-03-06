package org.prog.session16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.session16.page.W3ShcoolsPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

//TODO: Re-work you allo.ua tests to use page object

public class PageObjectTests {

    private WebDriver driver;
    private W3ShcoolsPage w3ShcoolsPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        w3ShcoolsPage = new W3ShcoolsPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void actionsTest() {
        w3ShcoolsPage.loadPage("/cssref/tryit.php?filename=trycss_sel_hover");
        w3ShcoolsPage.acceptCookiesIfPresent();
        w3ShcoolsPage.switchToFrame(By.id("iframeResult_0"));

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions linkActions = new Actions(driver);
        WebElement link1 = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("w3schools.com")));
        WebElement link2 = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("wikipedia.org")));
        linkActions.moveToElement(link1);
        linkActions.pause(Duration.ofSeconds(5));
        linkActions.moveToElement(link2);
        linkActions.pause(Duration.ofSeconds(5));
        linkActions.perform();
    }

    @Test
    public void iFrameTest() {
        w3ShcoolsPage.loadPage("/tags/tryit.asp?filename=tryhtml_button_test");
        w3ShcoolsPage.acceptCookiesIfPresent();
        w3ShcoolsPage.switchToFrame(By.id("iframeResult"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element =
                webDriverWait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//button[text()='Click Me!']")));
    }

    @Test
    public void myWebTest() {
        driver.get("https://www.cloudflare.com/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));

//        WebElement acceptCookies =webDriverWait.until(
//                ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
//        acceptCookies.click();

        webDriverWait
                .until(
                        ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")))
                .click();

        WebElement sideMenu = driver.findElement(By.xpath(
                "//button[@aria-label='Toggle menu']"));
        sideMenu.click();

        WebElement loginBtn = driver.findElement(By.linkText("Log in"));
        loginBtn.click();

//        WebElement emailInput = driver.findElement(By.id("email"));
//        emailInput.click();
//        emailInput.sendKeys("test@test.com");
//
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        passwordInput.click();
//        passwordInput.sendKeys("test123");

        System.out.println("done!");
    }
}
