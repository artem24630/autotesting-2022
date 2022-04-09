package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends LoadableComponent<ProfilePage> {

    private static final ProfilePage INSTANSE = new ProfilePage();

    private static final By PROFILE_BTN = By.xpath("//a[@data-l='t,userPage']");
    private static final By AVATAR = By.id("hook_Block_Avatar");
    private static final By USER_INFO = By.id("hook_Block_AboutUserRB");
    private static final By USERNAME = By.xpath("//*[@id='hook_Block_AboutUserRB']/div");

    private static final By FRIENDS_BTN = By.xpath("//a[@data-l='t,userFriend']");
    private static final By MESSAGES_BTN = By.id("msg_toolbar_button");
    private static final By NEWS_FEED_BTN = By.xpath("//a[@data-l='t,userMain']");

    private ProfilePage() {
    }

    @Override
    protected void load() {
        $(PROFILE_BTN)
                .should(exist.because("Profile button isn't rendered"))
                .shouldBe(visible.because("Profile button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(AVATAR).should(exist).shouldBe(visible);
        $(USER_INFO).should(exist).shouldBe(visible);
        $(USERNAME).should(exist).shouldBe(visible).shouldNotBe(empty);
    }

    public static ProfilePage getInstanse() {
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

    public NewsFeedPage goToNewsFeedPage() {
        $(NEWS_FEED_BTN)
                .should(exist.because("News feed button isn't rendered"))
                .shouldBe(visible.because("News feed button isn't displayed")).click();
        return NewsFeedPage.getInstanse().get();
    }

}

