package pages.elements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ChatsPageElement extends LoadableComponent<ChatsPageElement> {

    private static final By CHATS_LIST = By.cssSelector("msg-chats-list");
    private static final By CHATS_LIST_ITEM = By.cssSelector("msg-chats-list-item");

    private static final By CHAT_TITLE = By.xpath(".//div[@data-tsid='conversation_name']//msg-parsed-text");
    private static final By CREATE_CHAT_BTN = By.xpath("//msg-menu-item[@data-tsid='plus_create_chat']");
    private static final By CHAT_TITLE_INPUT = By.xpath("//msg-input[@data-tsid='chat-theme']");
    private static final By FINISH_CREATE_CHAT_BTN = By.xpath("//msg-button[@data-tsid='finish_create_chat_button']");
    private static final By OPEN_PLUS_BTN = By.xpath("//msg-button[@data-tsid='open_plus_button']");

    private static final By INFO_CHAT_BTN = By.xpath("//msg-button[@data-l='t,showChatInfo']");
    private static final By DELETE_CHAT_BTN = By.xpath("//msg-tico[@data-tsid='remove-dialog-btn']");
    private static final By DELETE_CHAT_CONFIRM_BTN = By.xpath("//msg-button[@data-tsid='confirm-primary']");

    private ElementsCollection chatsList;

    @Override
    protected void load() {
        chatsList = $$(CHATS_LIST_ITEM);
    }

    @Override
    protected void isLoaded() throws Error {
        $(CHATS_LIST).should(exist);
        assert (chatsList != null);
    }

    public SelenideElement getFirstChat() {
        return chatsList.isEmpty() ? null : chatsList.first();
    }

    public List<String> getAllChatsTitles() {
        chatsList = $$(CHATS_LIST_ITEM);
        List<String> chatsTitles = new ArrayList<>(chatsList.size());
        for (SelenideElement chat : chatsList) {
            chatsTitles.add(chat.find(CHAT_TITLE).getText());
        }
        return chatsTitles;
    }

    public void createChatWithTitle(String title) {
        $(OPEN_PLUS_BTN).should(exist).click();
        $(CREATE_CHAT_BTN).should(exist).click();
        $(CHAT_TITLE_INPUT).should(exist).shouldBe(visible).setValue(title);
        $(FINISH_CREATE_CHAT_BTN).should(exist).shouldBe(visible).click();
    }

    public void deleteChatWithTitle(String title) {
        chatsList = $$(CHATS_LIST_ITEM);
        deleteChat(getChatElementByTitle(title));
    }

    private void deleteChat(SelenideElement chat) {
        chat.click();
        $(INFO_CHAT_BTN).click();
        $(DELETE_CHAT_BTN).click();
        $(DELETE_CHAT_CONFIRM_BTN).click();
    }

    private SelenideElement getChatElementByTitle(String title) {
        chatsList = $$(CHATS_LIST_ITEM);
        for (SelenideElement chat : chatsList) {
            if (chat.find(CHAT_TITLE).getText().equals(title)) {
                return chat;
            }
        }
        throw new NoSuchElementException(title);
    }

    public ChatPageElement getChatByTitle(String title) {
        return new ChatPageElement(title, getChatElementByTitle(title));
    }
}
