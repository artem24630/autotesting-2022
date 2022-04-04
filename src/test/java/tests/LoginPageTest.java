package tests;

import static com.codeborne.selenide.Condition.exist;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class LoginPageTest extends AbstractTest {

    private static final By NEWS_FEED = By.id("hook_Block_UserMainFullMRB");

    @Test
    void loginOK() {
        $(NEWS_FEED).should(exist).shouldBe(visible);
    }

}
