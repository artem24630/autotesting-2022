package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import utils.UserDetails;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {

    @Override
    protected void load() {
        Selenide.open("/");
    }

    @Override
    protected void isLoaded() throws Error {
        $(By.id("field_email")).should(exist);
        $(By.id("field_password")).should(exist);
        $(By.xpath("//input[@data-l='t,sign_in']")).should(exist);
        $(By.xpath("//a[@data-l='t,register']")).should(exist);
    }

    public void login(UserDetails userDetails) {
        $(By.id("field_email")).setValue(userDetails.login());
        $(By.id("field_password")).setValue(userDetails.password());
        $(By.xpath("//input[@data-l='t,sign_in']")).click();
    }
}
