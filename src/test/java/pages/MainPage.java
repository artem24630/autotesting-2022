package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MainPage extends LoadableComponent<LoginPage> {
    @Override
    protected void load() {
        open("/feed");
    }

    @Override
    protected void isLoaded() throws Error {
        $(By.xpath("//*[@data-l='fL,main,feedFilterId,201']")).should(exist);
    }
}
