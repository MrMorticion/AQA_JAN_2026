package org.prog.session18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.prog.session20.util.DBConnectionFactory;
import org.prog.session20.util.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

@CucumberOptions(
        tags = "@allo and not @skip",
        features = "src/test/resources/features",
        glue = "org.prog.session18",
        plugin = {
                "html:target/allo-cucumber-report.html",
                "json:target/cucumber-reports/AlloCucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class AlloCucumberRunner extends AbstractTestNGCucumberTests {

    private Connection conn;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException, MalformedURLException {
        conn = DBConnectionFactory.getConnection();
        AlloDBSteps.conn = conn;

        driver = WebDriverFactory.getDriver();
        AlloSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ignored) {
        }
    }
}