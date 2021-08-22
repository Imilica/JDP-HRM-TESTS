package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.EmployeesPageTestData;
import tests.TestBase;

public class HrmEmployeesPage extends TestBase {

    WebDriver driver;
    public static WaitHelper waitHelper = new WaitHelper();
    public static EmployeesPageTestData employeesPageTestData = new EmployeesPageTestData();


    public HrmEmployeesPage(WebDriver driver) {
        this.driver = driver;
        driver.get(employeesPageTestData.employeesPageURL);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'filter_list')]")
    public WebElement filterOnEmployeesPage;

    @FindBy(id = "mat-select-7")
    WebElement filterPositionOnEmployeesPage;

    @FindBy(id = "mat-option-129")
    public WebElement branchManagerPosition;

    @FindBy(css = ".header-filters__btn.hrmBtn.hrmBtn--primary")
    public WebElement applyButton;

    @FindBy(css = ".cdk-overlay-backdrop")
    WebElement overlay;

    //  @FindBy(id = "mat-input-15")
    // public WebElement searchField;

    @FindBy(css = "[placeholder=\"Search employee\"]")
    public WebElement searchField;


    public void clickOnFilterOnEmployeesPage() {

        waitHelper.waitUntilElementIsVisible(driver, filterOnEmployeesPage, 15);
        waitHelper.waitUntilElementIsClickable(driver, filterOnEmployeesPage, 15);
        filterOnEmployeesPage.click();
    }

    public void checkPosition() {

        waitHelper.waitUntilElementIsVisible(driver, filterPositionOnEmployeesPage, 15);
        filterPositionOnEmployeesPage.click();
        waitHelper.waitUntilElementIsVisible(driver, branchManagerPosition, 15);
        branchManagerPosition.click();
    }


    public void clickOnApplyButton() {
        applyButton.click();
    }

    public void clickOnOverlay() {

        waitHelper.waitUntilElementIsVisible(driver, applyButton, 15);
        overlay.click();
    }

    public boolean isFilterOnEmployeesPageDisplayed() {
        return this.filterOnEmployeesPage.isDisplayed();

    }

    public boolean checkURLonEmployeesPage() {
        waitHelper.waitUntilElementIsVisible(driver, filterOnEmployeesPage, 10);
        String currentURL = driver.getCurrentUrl();
        return currentURL.contains(employeesPageTestData.employeesPageURL);

    }

    public boolean isPositionSelected() {
        return this.branchManagerPosition.getAttribute("aria-selected").equals("true");

    }

    public void searchValue(String value) {

        waitHelper.waitUntilElementIsVisible(driver, searchField, 10);
        waitHelper.waitUntilElementIsClickable(driver, searchField, 15);

        searchField.sendKeys(value);
        waitHelper.waitUntilValueContains(driver, searchField, 10, value);

    }

    public void pressEnterKey() {
        searchField.sendKeys(Keys.ENTER);
    }


}





