package pages.elements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ChatsPageElement extends LoadableComponent<ChatsPageElement> {

    private static final By CHATS_LIST = By.cssSelector("msg-chats-list");
    private static final By CHATS_LIST_ITEM = By.cssSelector("msg-chats-list-item");

    private ElementsCollection chatsList;

    @Override
    protected void load() {
        chatsList = $$(CHATS_LIST_ITEM);
    }

    @Override
    protected void isLoaded() throws Error {
        $(CHATS_LIST).should(exist);
        assert(chatsList != null);
    }

    public SelenideElement getFirstChat() {
        return chatsList.isEmpty() ? null : chatsList.first();
    }

}
