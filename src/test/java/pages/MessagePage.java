package pages;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import pages.elements.ChatPageElement;
import pages.elements.ChatsPageElement;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import java.util.List;

public class MessagePage extends LoadableComponent<MessagePage> {

    private static final By MESSAGE_PAGE_TITLE = By.xpath("//msg-l10n[@key='onboarding-title']");
    private static final By CHAT_WITH_PEOPLE = By.xpath(".//a[contains(@href, '/messages/')]");
    private static final By PEOPLE_AVATAR = By.xpath(".//img");
    private static final By CONVERSATION_NAME = By.xpath(".//div[@data-tsid='conversation_name']//msg-parsed-text");
    private static final By LAST_MESSAGE = By.xpath(".//div[@data-tsid='last_message']//msg-parsed-text");
    private static final By MESSAGES_BUTTON = By.xpath("//li[@data-l='t,messages']");

    @Override
    protected void load() {
        $(MESSAGES_BUTTON).shouldBe(visible.because("Messages button isn't displayed")).click();
    }

    @Override
    protected void isLoaded() throws Error {
        $(MESSAGE_PAGE_TITLE).shouldHave(text("Сообщения"));
        ChatsPageElement chatsList = new ChatsPageElement();
        chatsList.get();

        testFirstChat(chatsList);
    }

    private void testFirstChat(ChatsPageElement chatsPageElement) {
        SelenideElement firstChat = chatsPageElement.getFirstChat();
        if (firstChat != null) {
            firstChat.find(CHAT_WITH_PEOPLE).should(exist).shouldBe(visible);
            //firstChat.find(PEOPLE_AVATAR).should(exist).shouldBe(visible).shouldHave(image);
            firstChat.find(CONVERSATION_NAME).should(exist).shouldBe(visible).shouldNotBe(empty);
            firstChat.find(LAST_MESSAGE).should(exist).shouldBe(visible).shouldNotBe(empty);
        }
    }

    public List<String> getChatsTitle() {
        ChatsPageElement chatsList = new ChatsPageElement();
        chatsList.get();
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

    public ChatPageElement getChatWithTitle(String title) {
        ChatsPageElement chatsList = new ChatsPageElement().get();
        return chatsList.getChatByTitle(title);
    }
}
