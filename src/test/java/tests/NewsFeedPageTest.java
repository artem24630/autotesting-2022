package tests;

import org.junit.jupiter.api.Test;
import pages.NewsFeedPage;

public class NewsFeedPageTest extends AbstractTest {

    @Test
    void correctNewsFeedPage() {
        NewsFeedPage newsFeedPage = new NewsFeedPage();
        newsFeedPage.get();
    }

}
