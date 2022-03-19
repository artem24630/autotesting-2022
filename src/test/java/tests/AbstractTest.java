package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        Configuration.baseUrl = "https://ok.ru";
    }

    @AfterAll
    static void afterAll() {
        WebDriverRunner.closeWebDriver();
    }
}
