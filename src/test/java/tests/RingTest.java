package tests;

import org.junit.jupiter.api.Test;
import pages.NewsFeedPage;

public class RingTest extends AbstractTest {

    @Test
    public void NewsFeed_Messages_Profile_Friends_NewsFeed() {
        NewsFeedPage.getInstanse().get()
                .goToMessagesPage().get()
                .goToProfilePage().get()
                .goToFriendsPage().get()
                .goToNewsFeedPage().get();
    }

    @Test
    public void NewsFeed_Messages_Friends_Profile_NewsFeed() {
        NewsFeedPage.getInstanse().get()
                .goToMessagesPage().get()
                .goToFriendsPage().get()
                .goToProfilePage().get()
                .goToNewsFeedPage().get();
    }

    @Test
    public void NewsFeed_Friends_Messages_Profile_NewsFeed() {
        NewsFeedPage.getInstanse().get()
                .goToFriendsPage().get()
                .goToMessagesPage().get()
                .goToProfilePage().get()
                .goToNewsFeedPage().get();
    }

    @Test
    public void NewsFeed_Friends_Profile_Messages_NewsFeed() {
        NewsFeedPage.getInstanse().get()
                .goToFriendsPage().get()
                .goToProfilePage().get()
                .goToMessagesPage().get()
                .goToNewsFeedPage().get();
    }

    @Test
    public void NewsFeed_Profile_Messages_Friends_NewsFeed() {
        NewsFeedPage.getInstanse().get()
                .goToProfilePage().get()
                .goToMessagesPage().get()
                .goToFriendsPage().get()
                .goToNewsFeedPage().get();
    }

    @Test
    public void NewsFeed_Profile_Friends_Messages_NewsFeed() {
        NewsFeedPage.getInstanse().get()
                .goToProfilePage().get()
                .goToFriendsPage().get()
                .goToMessagesPage().get()
                .goToNewsFeedPage().get();
    }

}
