package pages.elements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

public class ChatsPageElement {

    private ElementsCollection chatsList;

    public ChatsPageElement() {
        chatsList = $$(By.cssSelector("msg-chats-list-item"));
    }

    public ElementsCollection getChats() {
        return chatsList;
    }

    public void isExisted() throws Error {
        $(By.cssSelector("msg-chats-list")).should(exist);
    }


}
