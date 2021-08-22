package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {

    @Test
    public void checkTheTitleOnProfilePage() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        String actualTitle = driver.getTitle();
        String expectedTitle = "HRM";

        Assert.assertTrue(actualTitle.equals(expectedTitle), "Title should be: " + expectedTitle);
        quickMenu.logout();


    }

    @Test
    public void verifyTopCardInfoNavigationTabs() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        Assert.assertTrue(hrmProfilePage.verifyEmployeeNavigationTabsAreDisplayed(), "Tabs: " +
                hrmProfilePage.basicTab + hrmProfilePage.leaveManagementTab + hrmProfilePage.relationManagementTab + hrmProfilePage.pdpTab +
                "should be displayed.");

        quickMenu.logout();

    }

    @Test
    public void verifyTopCardInfoFirstAndLastName() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        Assert.assertTrue(hrmProfilePage.isFirstAndLastNameDisplayed(), hrmProfilePage.firstAndLastName + "should be displayed.");
        quickMenu.logout();


    }

    @Test (enabled = false)
    public void verifyBasicInfo() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        Assert.assertTrue(hrmProfilePage.checkIsBasicInfoDisplayed(), "All basic info should be displayed.");
        quickMenu.logout();


    }
}
