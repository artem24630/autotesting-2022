package tests;

import org.junit.jupiter.api.Test;
import pages.NewsFeedPage;

public class RingTest extends AbstractTest {

    @Test
    public void NewsFeedMessagesProfileFriendsNewsFeed() {
        NewsFeedPage.getInstanse()
                .goToMessagesPage()
                .goToProfilePage()
                .goToFriendsPage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeedMessagesFriendsProfileNewsFeed() {
        NewsFeedPage.getInstanse()
                .goToMessagesPage()
                .goToFriendsPage()
                .goToProfilePage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeedFriendsMessagesProfileNewsFeed() {
        NewsFeedPage.getInstanse()
                .goToFriendsPage()
                .goToMessagesPage()
                .goToProfilePage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeedFriendsProfileMessagesNewsFeed() {
        NewsFeedPage.getInstanse()
                .goToFriendsPage()
                .goToProfilePage()
                .goToMessagesPage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeedProfileMessagesFriendsNewsFeed() {
        NewsFeedPage.getInstanse()
                .goToProfilePage()
                .goToMessagesPage()
                .goToFriendsPage()
                .goToNewsFeedPage();
    }

    @Test
    public void NewsFeedProfileFriendsMessagesNewsFeed() {
        NewsFeedPage.getInstanse()
                .goToProfilePage()
                .goToFriendsPage()
                .goToMessagesPage()
                .goToNewsFeedPage();
    }

}
