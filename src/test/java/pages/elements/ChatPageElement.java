package pages.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class ChatPageElement {
    private static final By CHAT_TITLE = By.xpath(".//div[@data-tsid='conversation_name']//msg-parsed-text");
    private final String title;
    private final SelenideElement chat;

    public ChatPageElement(String title, SelenideElement chatElementByTitle) {
        this.title = title;
        this.chat = chatElementByTitle;
    }
}
