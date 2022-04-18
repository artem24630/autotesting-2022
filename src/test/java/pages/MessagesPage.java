package pages;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import pages.elements.ChatsPageElement;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import java.util.List;

public class MessagesPage extends LoadableComponent<MessagesPage> {

    private static final MessagesPage INSTANSE = new MessagesPage();

    private static final By MESSAGE_PAGE_TITLE = By.xpath("//msg-l10n[@key='onboarding-title']");
    private static final By CHAT_WITH_PEOPLE = By.xpath(".//a[contains(@href, '/messages/')]");
    private static final By CONVERSATION_NAME = By.xpath(".//div[@data-tsid='conversation_name']//msg-parsed-text");
    private static final By LAST_MESSAGE = By.xpath(".//div[@data-tsid='last_message']//msg-parsed-text");
    private static final By MESSAGES_BTN = By.xpath("//li[@data-l='t,messages']");

    private static final By FRIENDS_BTN = By.xpath("//a[@data-l='t,userFriend']");
    private static final List<By> PROFILE_BTNS =
            List.of(By.xpath("//a[@data-l='t,userPage']"), By.id("hook_Block_CompactProfileBlock"));
    private static final By NEWS_FEED_BTN = By.xpath("//a[@data-l='t,userMain']");

    private MessagesPage() {
    }

    @Override
    protected void load() {
        $(MESSAGES_BTN)
                .should(exist.because("Messages button isn't rendered"))
                .shouldBe(visible.because("Messages button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(MESSAGE_PAGE_TITLE).shouldHave(text("Сообщения"));
        ChatsPageElement chatsList = new ChatsPageElement();
        chatsList.get();

        testFirstChat(chatsList);
    }

    public static MessagesPage getInstanse() {
        return INSTANSE;
    }

    public FriendsPage goToFriendsPage() {
        load();
        $(FRIENDS_BTN)
                .should(exist.because("Friends button isn't rendered"))
                .shouldBe(visible.because("Friends button isn't displayed")).click();
        return FriendsPage.getInstanse().get();
    }

    public NewsFeedPage goToNewsFeedPage() {
        load();
        $(NEWS_FEED_BTN)
                .should(exist.because("News feed button isn't rendered"))
                .shouldBe(visible.because("News feed button isn't displayed")).click();
        return NewsFeedPage.getInstanse().get();
    }

    public ProfilePage goToProfilePage() {
        load();
        for (By profileButton: PROFILE_BTNS) {
            if ($(profileButton).exists()) {
                $(profileButton).shouldBe(visible.because("Profile button isn't displayed")).click();
                return ProfilePage.getInstanse().get();
            }
        }
        throw new RuntimeException("Profile button isn't rendered");
    }

    public List<String> getChatsTitle() {
        ChatsPageElement chatsList = new ChatsPageElement().get();
        return chatsList.getAllChatsTitles();
    }

    public void createChatWithTitle(String title) {
        ChatsPageElement chatsList = new ChatsPageElement().get();
        chatsList.createChatWithTitle(title);
    }

    public void deleteChatWithTitle(String title) {
        ChatsPageElement chatsList = new ChatsPageElement().get();
        chatsList.deleteChatWithTitle(title);
    }

    private void testFirstChat(ChatsPageElement chatsPageElement) {
        SelenideElement firstChat = chatsPageElement.getFirstChat();
        if (firstChat != null) {
            firstChat.find(CHAT_WITH_PEOPLE).should(exist).shouldBe(visible);
            firstChat.find(CONVERSATION_NAME).should(exist).shouldBe(visible).shouldNotBe(empty);
            firstChat.find(LAST_MESSAGE).should(exist).shouldBe(visible).shouldNotBe(empty);
        }
    }

}
