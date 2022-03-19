package tests;

import pages.LoginPage;
import utils.UserDetails;
import org.junit.jupiter.api.Test;

class LoginPageTest extends AbstractTest {

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage();
        UserDetails userDetails = new UserDetails("89214332531", "31072002");
        loginPage.get().login(userDetails);
    }
}
