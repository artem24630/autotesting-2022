package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import utils.UserDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {

    private static final By EMAIL_FIELD = By.id("field_email");
    private static final By PASSWORD_FIELD = By.id("field_password");
    private static final By INPUT_BUTTON = By.xpath("//input[@data-l='t,sign_in']");
    private static final By REGISTER_BUTTON = By.xpath("//a[@data-l='t,register']");

    @Override
    protected void load() {
        open("/");
    }

    @Override
    protected void isLoaded() throws Error {
        $(EMAIL_FIELD).should(exist);
        $(PASSWORD_FIELD).should(exist);
        $(INPUT_BUTTON).should(exist);
        $(REGISTER_BUTTON).should(exist);
    }

    public NewsFeedPage login(UserDetails userDetails) {
        $(EMAIL_FIELD).shouldBe(visible.because("Email field isn't displayed!")).setValue(userDetails.login());
        $(PASSWORD_FIELD).shouldBe(visible.because("Password field isn't displayed!")).setValue(userDetails.password());
        $(INPUT_BUTTON).shouldBe(visible.because("Login button isn't displayed")).click();

        return NewsFeedPage.getInstanse().get();
    }

}
