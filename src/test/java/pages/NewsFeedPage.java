package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewsFeedPage extends LoadableComponent<NewsFeedPage> {

    private static final NewsFeedPage INSTANSE = new NewsFeedPage();

    private static final By NEWS_FEED = By.id("hook_Block_UserMainFullMRB");
    private static final By NAVIGATION_TOOLBAR = By.xpath("//div[@data-l='t,navigationToolbar']");
    private static final By NEWS_FEED_BTN = By.xpath("//li[@data-l='t,userMain']");
    private static final By ECOSYSTEM_TOOLBAR = By.id("ph-whiteline");

    private static final By FRIENDS_BTN = By.xpath("//a[@data-l='t,userFriend']");
    private static final By PROFILE_BTN = By.xpath("//a[@data-l='t,userPage']");
    private static final By MESSAGES_BTN = By.xpath("//li[@data-l='t,messages']");

    private NewsFeedPage() {
    }

    @Override
    protected void load() {
        $(NEWS_FEED_BTN)
                .should(exist.because("News feed button isn't rendered"))
                .shouldBe(visible.because("News feed button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(NEWS_FEED).should(exist).shouldBe(visible);
        $(NAVIGATION_TOOLBAR).should(exist).shouldBe(visible);
        $(ECOSYSTEM_TOOLBAR).should(exist).shouldBe(visible);
    }

    public static NewsFeedPage getInstanse() {
        return INSTANSE;
    }

    public FriendsPage goToFriendsPage() {
        $(FRIENDS_BTN)
                .should(exist.because("Friends button isn't rendered"))
                .shouldBe(visible.because("Friends button isn't displayed")).click();
        return FriendsPage.getInstanse().get();
    }

    public MessagesPage goToMessagesPage() {
        $(MESSAGES_BTN)
                .should(exist.because("Messages button isn't rendered"))
                .shouldBe(visible.because("Messages button isn't displayed")).click();
        return MessagesPage.getInstanse().get();
    }

    public ProfilePage goToProfilePage() {
        $(PROFILE_BTN)
                .should(exist.because("Profile button isn't rendered"))
                .shouldBe(visible.because("Profile button isn't displayed")).click();
        return ProfilePage.getInstanse().get();
    }

}
