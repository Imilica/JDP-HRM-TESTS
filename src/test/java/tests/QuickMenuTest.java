package tests;

import org.testng.annotations.Test;

public class QuickMenuTest extends TestBase {

    @Test
    public void LogoutTest() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);
        quickMenu.clickOnMenu();
        quickMenu.clickOnLogoutButton();

    }
}
