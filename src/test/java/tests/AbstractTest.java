package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NewsPage;
import utils.UserDetails;

public abstract class AbstractTest {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverRunner.setWebDriver(new ChromeDriver());
        Configuration.baseUrl = "https://ok.ru";

        LoginPage loginPage = new LoginPage();
        UserDetails userDetails = new UserDetails("89214332531", "31072002");
        NewsPage newsPage = loginPage.get().login(userDetails);
        newsPage.get();
    }

    @AfterAll
    static void afterAll() {
        WebDriverRunner.closeWebDriver();
    }

}
