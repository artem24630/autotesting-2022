package tests;

import org.junit.jupiter.api.Test;
import pages.FriendsPage;

public class FriendsPageTest extends AbstractTest {

    @Test
    void correctFriendsPage() {
        FriendsPage.getInstanse().get();
    }

}
