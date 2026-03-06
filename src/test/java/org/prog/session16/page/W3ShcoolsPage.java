package org.prog.session16.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3ShcoolsPage {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    private final static String BASE_URL = "https://www.w3schools.com/";

    public W3ShcoolsPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void loadPage(String path) {
        driver.get(BASE_URL + path);
    }

    public void acceptCookiesIfPresent() {
        WebElement cookiesFrame;
        try {
            cookiesFrame =
                    webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("fast-cmp-iframe")));
        } catch (TimeoutException e){
            System.out.println("Cookies already accepted - skip!");
            return;
        }
        driver.switchTo().frame(cookiesFrame);
        //accept cookies
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Accept']")))
                .click();
        driver.switchTo().defaultContent();
    }

    public void switchToFrame(By locator) {
        WebElement iFrame = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(locator));
        driver.switchTo().frame(iFrame);
    }
}
