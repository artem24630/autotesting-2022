package tests;

import org.openqa.selenium.By;
import pages.MessagePage;
import org.junit.jupiter.api.Test;
import pages.NewsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class MessagePageTest extends AbstractTest {

    private static final By MESSAGES_BUTTON = By.xpath("//li[@data-l='t,messages']");

    @Test
    void correctMessagePage() {
        MessagePage messagePage = clickOnMessages();
        messagePage.get();
    }

    private MessagePage clickOnMessages() {
        $(MESSAGES_BUTTON).shouldBe(visible.because("Messages button isn't displayed")).click();
        return new MessagePage();
    }

}
