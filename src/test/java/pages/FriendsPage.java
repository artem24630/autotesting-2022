package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage extends LoadableComponent<ProfilePage> {

    private static final By RECOMMENDATIONS = By.id("hook_Block_MyFriendsNewPageMRB");
    private static final By FRIENDS_CATALOG = By.id("UserFriendsCatalogRB");
    private static final By ALL_FRIENDS = By.id("hook_Block_MyFriendsSquareCardsPagingB");
    private static final By FRIENDS_BUTTON = By.xpath("//a[@data-l='t,userFriend']");

    @Override
    protected void load() {
        $(FRIENDS_BUTTON).shouldBe(visible.because("News button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(RECOMMENDATIONS).should(exist).shouldBe(visible);
        $(FRIENDS_CATALOG).should(exist).shouldBe(visible);
        $(ALL_FRIENDS).should(exist).shouldBe(visible);
    }

}
