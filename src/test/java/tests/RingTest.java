package tests;

import org.junit.jupiter.api.Test;
import pages.NewsFeedPage;

public class RingTest extends AbstractTest {

    @Test
    public void NewsFeed_Messages_Profile_Friends_NewsFeed() {
        NewsFeedPage.getInstanse()
                .goToMessagesPage()
                .goToProfilePage()
                .goToFriendsPage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeed_Messages_Friends_Profile_NewsFeed() {
        NewsFeedPage.getInstanse()
                .goToMessagesPage()
                .goToFriendsPage()
                .goToProfilePage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeed_Friends_Messages_Profile_NewsFeed() {
        NewsFeedPage.getInstanse()
                .goToFriendsPage()
                .goToMessagesPage()
                .goToProfilePage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeed_Friends_Profile_Messages_NewsFeed() {
        NewsFeedPage.getInstanse()
                .goToFriendsPage()
                .goToProfilePage()
                .goToMessagesPage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeed_Profile_Messages_Friends_NewsFeed() {
        NewsFeedPage.getInstanse()
                .goToProfilePage()
                .goToMessagesPage()
                .goToFriendsPage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeed_Profile_Friends_Messages_NewsFeed() {
        NewsFeedPage.getInstanse()
                .goToProfilePage()
                .goToFriendsPage()
                .goToMessagesPage()
                .goToNewsFeedPage();
    }

}
