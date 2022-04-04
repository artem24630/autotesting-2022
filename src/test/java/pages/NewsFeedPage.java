package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewsFeedPage extends LoadableComponent<NewsFeedPage> {

    private static final By NEWS_FEED = By.id("hook_Block_UserMainFullMRB");
    private static final By NAVIGATION_TOOLBAR = By.xpath("//div[@data-l='t,navigationToolbar']");
    private static final By NEWS_BUTTON = By.xpath("//li[@data-l='t,userMain']");
    private static final By ECOSYSTEM_TOOLBAR = By.id("ph-whiteline");

    @Override
    protected void load() {
        $(NEWS_BUTTON).shouldBe(visible.because("News button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(NEWS_FEED).should(exist).shouldBe(visible);
        $(NAVIGATION_TOOLBAR).should(exist).shouldBe(visible);
        $(ECOSYSTEM_TOOLBAR).should(exist).shouldBe(visible);
    }

}
