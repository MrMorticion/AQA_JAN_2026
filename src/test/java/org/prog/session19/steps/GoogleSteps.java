package org.prog.session19.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.session19.DataHolder;

import java.util.List;

public class GoogleSteps {

    public static WebDriver driver;

    @Given("I open google main page")
    public void openGooglePage() {
        driver.get("https://www.google.com/");
    }

    @Given("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        List<WebElement> cookiesLink = driver.findElements(By.xpath(
                "//a[contains(@href,'technologies/cookies')]"));
        if (!cookiesLink.isEmpty() && cookiesLink.get(0).isDisplayed()) {
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            buttons.get(buttons.size() - 2).click();
        } else {
            System.out.println("No cookies link found - proceed");
        }
    }

    @Given("I set search field to {string} first and last name")
    public void setSearchFieldToThatPersonFirstAndLastName(String alias) throws InterruptedException {
        List<String> names = (List<String>) DataHolder.data.get(alias);
        String firstLastName = names.get(0);
        System.out.println("I will search for " + firstLastName);
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(firstLastName);
        Thread.sleep(1000);
    }
}
