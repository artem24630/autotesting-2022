package tests;

import org.openqa.selenium.By;
import pages.MessagePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

class MessagePageTest extends AbstractTest {

    @Test
    void correctMessagePage() {
        MessagePage messagePage = new MessagePage();
        messagePage.get();
    }

}
