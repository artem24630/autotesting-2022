package tests;

import pages.LoginPage;
import utils.UserDetails;
import org.junit.jupiter.api.Test;

class LoginPageTest extends AbstractTest {

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage();
        UserDetails userDetails = new UserDetails("", "");
        loginPage.get().login(userDetails);
    }
}
