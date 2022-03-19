package tests;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.image;
import pages.LoginPage;
import pages.MessagePage;
import pages.elements.ChatsPageElement;
import utils.UserDetails;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class MessagePageTest extends AbstractTest {

    @Test
    void testMessage() {
        LoginPage loginPage = new LoginPage();
        UserDetails userDetails = new UserDetails("89214332531", "31072002");
        loginPage.get().login(userDetails);

        MessagePage messagePage = new MessagePage();
        messagePage.get();
        ChatsPageElement chats = messagePage.getChats();
        if (!chats.getChats().isEmpty()) {
            SelenideElement element = chats.getChats().first();
            element.find(By.xpath(".//a[contains(@href, '/messages/')]")).should(exist);
            element.find(By.xpath(".//img")).shouldHave(image);
            element.find(By.xpath(".//div[@data-tsid='conversation_name']//msg-parsed-text")).shouldNotBe(empty);
            element.find(By.xpath(".//div[@data-tsid='last_message']//msg-parsed-text")).shouldNotBe(empty);
        }
    }
}
