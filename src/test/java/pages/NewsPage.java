package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends LoadableComponent<NewsPage> {

    private static final By NEWS_FEED = By.id("hook_Block_UserMainFullMRB");
    private static final By NEWS_BUTTON = By.xpath("//li[@data-l='t,userMain']");

    @Override
    protected void load() {
        $(NEWS_BUTTON).shouldBe(visible.because("News button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(NEWS_FEED).should(exist).shouldBe(visible);
    }

}
