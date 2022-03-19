package tests;

import static com.codeborne.selenide.Condition.image;
import pages.LoginPage;
import pages.MessagePage;
import pages.elements.ChatsPageElement;
import utils.UserDetails;
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
            chats.getChats().first().find(By.xpath("//img")).shouldHave(image);
        }
    }
}
