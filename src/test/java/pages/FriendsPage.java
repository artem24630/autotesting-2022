package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage extends LoadableComponent<FriendsPage> {

    private static final FriendsPage INSTANSE = new FriendsPage();

    private static final By RECOMMENDATIONS = By.id("hook_Block_MyFriendsNewPageMRB");
    private static final By FRIENDS_CATALOG = By.id("UserFriendsCatalogRB");
    private static final By ALL_FRIENDS = By.id("hook_Block_MyFriendsSquareCardsPagingB");
    private static final By FRIENDS_BTN = By.xpath("//a[@data-l='t,userFriend']");

    private static final By MESSAGES_BTN = By.id("msg_toolbar_button");
    private static final By NEWS_FEED_BTN = By.xpath("//a[@data-l='t,userMain']");
    private static final By PROFILE_BTN = By.id("hook_Block_CompactProfileBlock");

    private FriendsPage() {
    }

    @Override
    protected void load() {
        $(FRIENDS_BTN)
                .should(exist.because("Friends button isn't rendered"))
                .shouldBe(visible.because("Friends button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(RECOMMENDATIONS).should(exist).shouldBe(visible);
        $(FRIENDS_CATALOG).should(exist).shouldBe(visible);
        $(ALL_FRIENDS).should(exist).shouldBe(visible);
    }

    public static FriendsPage getInstanse() {
        return INSTANSE;
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

    public ProfilePage goToProfilePage() {
        $(PROFILE_BTN)
                .should(exist.because("Profile button isn't rendered"))
                .shouldBe(visible.because("Profile button isn't displayed")).click();
        return ProfilePage.getInstanse().get();
    }

}
