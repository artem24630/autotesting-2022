package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends LoadableComponent<ProfilePage> {

    private static final By PROFILE_BUTTON = By.xpath("//a[@data-l='t,userPage']");
    private static final By AVATAR = By.id("hook_Block_Avatar");
    private static final By USER_INFO = By.id("hook_Block_AboutUserRB");
    private static final By USERNAME = By.xpath("//*[@id='hook_Block_AboutUserRB']/div");

    @Override
    protected void load() {
        $(PROFILE_BUTTON).shouldBe(visible.because("News button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(AVATAR).should(exist).shouldBe(visible);
        $(USER_INFO).should(exist).shouldBe(visible);
        $(USERNAME).should(exist).shouldBe(visible).shouldNotBe(empty);
    }

}
