package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.ProfilePageTestData;
import tests.TestBase;

public class HrmProfilePage extends TestBase {

    WebDriver driver;
    public static WaitHelper waitHelper= new WaitHelper();
    public static ProfilePageTestData profilePageTestData = new ProfilePageTestData();


    @FindBy(css = "div.employee__navigation--icons--node")
    public WebElement basicTab;

    @FindBy(id = "leave-management-tab")
    public WebElement leaveManagementTab;

    @FindBy(id = "relation-management-tab")
    public WebElement relationManagementTab;

    @FindBy(id = "pdp-tab")
    public WebElement pdpTab;

    @FindBy (css = "p.ng-binding")
    public WebElement firstAndLastName;

    @FindBy (id = "input_244")
    public WebElement fullName;

    @FindBy (id = "input_255")
    public WebElement inCompany;

    @FindBy (partialLinkText = "@htecgroup.com")
    public WebElement companyEmail;

    @FindBy(id = "select_value_label_240")
    public WebElement branch;

    @FindBy(id = "select_value_label_241")
    public WebElement gender;


    public HrmProfilePage(WebDriver driver) {
        this.driver = driver;
        driver.get(profilePageTestData.profilePageURL);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyEmployeeNavigationTabsAreDisplayed(){

        if(!basicTab.isDisplayed()){
            return false;
        }
        if(!leaveManagementTab.isDisplayed()){
            return false;
        }
        if(!relationManagementTab.isDisplayed()){
            return false;
        }
        if(!pdpTab.isDisplayed()){
            return false;
        }
        return true;

    }
    public boolean isFirstAndLastNameDisplayed(){
        return this.firstAndLastName.isDisplayed();


    }
    public boolean checkIsBasicInfoDisplayed(){

        if(!companyEmail.isDisplayed()){
            return false;
        }
        if(!fullName.isDisplayed()){
            return false;
        }
        if(!inCompany.isDisplayed()){
            return false;
        }
        if(!gender.isDisplayed()){
            return false;
        }
        return true;

    }


}
