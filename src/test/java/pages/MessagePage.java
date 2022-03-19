package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import pages.elements.ChatsPageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MessagePage extends LoadableComponent<MessagePage> {

    @Override
    protected void load() {
        open("/messages");
    }

    @Override
    protected void isLoaded() throws Error {
        $(By.xpath("//msg-l10n[@key='onboarding-title']")).shouldHave(text("Сообщения"));
        ChatsPageElement chatsList = new ChatsPageElement();
        chatsList.isExisted();
    }

    public ChatsPageElement getChats() {
        return new ChatsPageElement();
    }


}
