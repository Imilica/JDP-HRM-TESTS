package tests;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest extends TestBase {


    @Test
    public void verifyLoginWithValidEmailAndPassword() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        Assert.assertTrue(loginPage.checkTitleOnProfilePage(), "Title should be: " + loginTestData.expectedTitle);

        quickMenu.logout();


    }

    @Test
    public void verifyLoginWithInvalidEmail() {

        loginPage.clickOnLoginButton();
        utils.switchToMainWindowHandler();

        loginPage.setEmail(loginTestData.invalidLoginEmail);
        waitHelper.waitUntilValueContains(driver, loginPage.userEmail, 5, loginTestData.invalidLoginEmail);

        loginPage.clickOnEmailButton();

        Assert.assertTrue(loginPage.isMessageForIncorrectEmailDisplayed(),
                "Message: 'Нисмо успели да пронађемо ваш Google налог' should be displayed.'");


    }

    @Test
    public void verifyLoginWithInvalidPassword() {

        loginPage.clickOnLoginButton();
        utils.switchToMainWindowHandler();

        loginPage.setEmail(loginTestData.userLoginEmail);
        waitHelper.waitUntilValueContains(driver, loginPage.userEmail, 5, loginTestData.userLoginEmail);

        loginPage.clickOnEmailButton();

        loginPage.setPassword(loginTestData.invalidLoginPassword);
        waitHelper.waitUntilValueContains(driver, loginPage.userPassword, 2, loginTestData.invalidLoginPassword);

        loginPage.clickOnPasswordButton();

        Assert.assertTrue(loginPage.isMessageForIncorrectPasswordDisplayed(),
                "Message: 'Погрешна лозинка. Пробајте поново или кликните на Заборавили сте лозинку да бисте је ресетовали.' should be displayed.'");

    }
}
