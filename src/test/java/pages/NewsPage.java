package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewsPage extends LoadableComponent<NewsPage> {

    private static final By NEWS_FEED = By.id("hook_Block_UserMainFullMRB");
    private static final By MESSAGES_BUTTON = By.xpath("//li[@data-l='t,messages']");

    @Override
    protected void load() {
        open("/feeds");
    }

    @Override
    protected void isLoaded() throws Error {
        $(NEWS_FEED).should(exist).shouldBe(visible);
    }

    public MessagePage clickOnMessages() {
        $(MESSAGES_BUTTON).shouldBe(visible.because("Messages button isn't displayed")).click();
        return new MessagePage();
    }

}
