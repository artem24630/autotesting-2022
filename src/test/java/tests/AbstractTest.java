package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NewsFeedPage;
import utils.UserDetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class AbstractTest {

    private static final String os = System.getProperty("os.name").toLowerCase();
    private static final String webDriverFilename;

    static {
        webDriverFilename = os.contains("win")
                ? "src/test/resources/chromedriver.exe"
                : "src/test/resources/chromedriver";
    }

    @BeforeAll
    static void beforeAll() throws IOException {
        System.setProperty("webdriver.chrome.driver", webDriverFilename);
        WebDriverRunner.setWebDriver(new ChromeDriver());
        Configuration.baseUrl = "https://ok.ru";

        LoginPage loginPage = new LoginPage();
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/userdetails.txt"));
        String login = br.readLine();
        String password = br.readLine();
        UserDetails userDetails = new UserDetails(login, password);
        loginPage.get().login(userDetails);
    }

    @AfterAll
    static void afterAll() {
        WebDriverRunner.closeWebDriver();
    }

}
