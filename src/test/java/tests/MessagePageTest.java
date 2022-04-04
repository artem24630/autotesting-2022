package tests;

import pages.MessagePage;
import org.junit.jupiter.api.Test;
import pages.NewsPage;

class MessagePageTest extends AbstractTest {

    @Test
    void correctMessagePage() {
        MessagePage messagePage = new NewsPage().clickOnMessages();
        messagePage.get();
    }

}
