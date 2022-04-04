package tests;

import pages.MessagePage;
import org.junit.jupiter.api.Test;

class MessagePageTest extends AbstractTest {

    @Test
    void correctMessagePage() {
        MessagePage messagePage = new MessagePage();
        messagePage.get();
    }

}
