package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class QuickMenu extends TestBase {

    WebDriver driver;
    public static WaitHelper waitHelper = new WaitHelper();

    @FindBy(css = ".mat-menu-trigger.status-menu__button")
    public WebElement statusMenuButton;

    @FindBy(xpath = "//*[contains(text(), ' Log out of HRM ')]")
    public WebElement logoutButton;



    public QuickMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMenu() {

        waitHelper.waitUntilElementIsVisible(driver, statusMenuButton, 10);
        waitHelper.waitUntilElementIsClickable(driver, statusMenuButton, 10);

        statusMenuButton.click();

    }

    public void clickOnLogoutButton() {
        waitHelper.waitUntilElementIsVisible(driver, logoutButton, 10);
        waitHelper.waitUntilElementIsClickable(driver, logoutButton, 10);
        //is present
        logoutButton.click();

    }

    public void logout() {

        clickOnMenu();
        clickOnLogoutButton();
    }
}
