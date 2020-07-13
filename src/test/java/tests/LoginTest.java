package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidData() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("kristina@mailinator.com", "password123")
                .verifyLoginSuccess();
    }

    @Test
    public void loginWithEmptyFields() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("", "")
                .verifyErrorMessageIsDisplayed();
    }

    @Test
    public void loginWithIncorrectPassword() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("kristina@mailinator.com", "123")
                .verifyErrorMessageIsDisplayed();
    }
}
