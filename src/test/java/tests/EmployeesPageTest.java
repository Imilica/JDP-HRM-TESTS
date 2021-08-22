package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EmployeesPageTest extends TestBase {


    @Test
    public void navigateToEmployeesPage() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);
        utils.navigateTo(employeesPageTestData.employeesPageURL);

        Assert.assertTrue(employeesPage.checkURLonEmployeesPage(), "Current URL should be:" + employeesPageTestData.employeesPageURL);
        quickMenu.logout();


    }

    @Test()
    public void checkFiltersForBranchManagerPosition() {

        SoftAssert softAssertion = new SoftAssert();

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        utils.navigateTo(employeesPageTestData.employeesPageURL);

        employeesPage.clickOnFilterOnEmployeesPage();

        softAssertion.assertTrue(employeesPage.isFilterOnEmployeesPageDisplayed(), "Filter on Employees page should be displayed.");

        employeesPage.checkPosition();

        softAssertion.assertTrue(employeesPage.isPositionSelected(), "Branch manager should be selected. ");

        employeesPage.clickOnOverlay();
        employeesPage.clickOnApplyButton();

        softAssertion.assertAll();
        quickMenu.logout();


    }

    @Test(enabled = false)
    public void findEmployee() {

        loginPage.login(loginTestData.userLoginEmail, loginTestData.userLoginPassword);

        utils.navigateTo(employeesPageTestData.employeesPageURL);

        employeesPage.searchValue(employeesPageTestData.searchValue);

        employeesPage.pressEnterKey();

        Assert.assertTrue(employeesPage.searchField.getAttribute("value").contains(employeesPageTestData.searchValue),
                "Search field should contain " + employeesPageTestData.searchValue);

        quickMenu.logout();

    }


}