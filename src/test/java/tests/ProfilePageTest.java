package tests;

import org.junit.jupiter.api.Test;
import pages.ProfilePage;

public class ProfilePageTest extends AbstractTest {

    @Test
    void correctProfilePage() {
        ProfilePage profilePage = new ProfilePage();
        profilePage.get();
    }

}
