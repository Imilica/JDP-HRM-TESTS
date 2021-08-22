package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.LoginTestData;
import tests.TestBase;


public class HrmLoginPage extends TestBase {

    WebDriver driver;
    public static WaitHelper waitHelper = new WaitHelper();
    public static LoginTestData loginTestData = new LoginTestData();
    public static UtilsPage utils = new UtilsPage();


    @FindBy(className = "hrmLogin__login-btn")
    public WebElement loginButton;

    @FindBy(id = "identifierId")
    public WebElement userEmail;

    @FindBy(css = "input[name='password']")
    public WebElement userPassword;

    @FindBy(id = "identifierNext")
    public WebElement submitEmailButton;

    @FindBy(id = "passwordNext")
    public WebElement submitPasswordButton;

    @FindBy(css = "div.o6cuMc")
    public WebElement incorrectEmailMessage;

    @FindBy(xpath = "//*[contains(text(),'Погрешна лозинка. Пробајте поново или кликните на Заборавили сте лозинку да бисте је ресетовали.')]")
    public WebElement incorrectPasswordMessage;

    @FindBy(className = "WBW9sf")
    public WebElement savedEmail;

    @FindBy(className = "checkout-reminder__button--close")
    public WebElement checkoutReminderClose;

    public HrmLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(loginTestData.loginPageURL);
        PageFactory.initElements(driver, this);
    }

    private boolean IsEmailSaved(){
        return  driver.findElements(By.className("WBW9sf")).size() > 0;
    }

    private void loginWithSavedEmail(){
        this.clickOnSavedEmail();
        utils.switchToMainWindow();
    }

    private void  loginWithNewUser(String email, String password){
        this.setEmail(email);
        waitHelper.waitUntilValueContains(driver, userEmail, 5, email);

        this.clickOnEmailButton();

        this.setPassword(password);
        waitHelper.waitUntilValueContains(driver, userPassword, 2, email);

        this.clickOnPasswordButton();
        utils.switchToMainWindow();
        this.waitUntilLoginButtonIsNotPresent();
    }
    public void login(String email, String password) {

        this.clickOnLoginButton();
        utils.switchToMainWindowHandler();

        if (IsEmailSaved()) {
            loginWithSavedEmail();
        }else{
            loginWithNewUser(email,password);
        }

        waitHelper.waitUntilElementIsVisible(driver, By.cssSelector(".mat-menu-trigger.status-menu__button"), 20);

        // In case checkout reminder popup is shown also close that one
        if(driver.findElements(By.className("checkout-reminder__button--close")).size() > 0){
            checkoutReminderClose.click();
        }
    }


    public HrmLoginPage setEmail(String email) {

        waitHelper.waitUntilElementIsVisible(driver, By.id("identifierId"), 10);
        waitHelper.waitUntilElementIsVisible(driver, By.id("identifierNext"), 15);
        userEmail.sendKeys(email);
        return this;
    }


    public HrmLoginPage setPassword(String password) {

        waitHelper.waitUntilElementIsVisible(driver, By.name("password"), 10);
        waitHelper.waitUntilElementIsVisible(driver, By.id("passwordNext"), 3);
        userPassword.sendKeys(password);
        return this;
    }

    public void clickOnLoginButton() {
        waitHelper.waitUntilElementIsVisible(driver, By.className("hrmLogin__login-btn"), 30);
        waitHelper.waitUntilElementIsClickable(driver, By.className("hrmLogin__login-btn"), 30);
        waitHelper.driverWait(driver,1000);
        loginButton.click();
    }


    public void clickOnEmailButton() {

        submitEmailButton.click();
    }

    public void clickOnPasswordButton() {

        submitPasswordButton.click();
    }

    public boolean isMessageForIncorrectEmailDisplayed() {

        waitHelper.waitUntilElementIsVisible(driver, incorrectEmailMessage, 15);
        return incorrectEmailMessage.getText().contains("Нисмо успели да пронађемо ваш Google налог");
    }

    public boolean isMessageForIncorrectPasswordDisplayed() {

        waitHelper.waitUntilElementIsVisible(driver, incorrectPasswordMessage, 10);
        return incorrectPasswordMessage.getText().contains("Погрешна лозинка. Пробајте поново или кликните на Заборавили сте лозинку да бисте је ресетовали.");
    }

    public boolean checkTitleOnProfilePage() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "HRM";

        return actualTitle.equals(expectedTitle);

    }

    public void waitUntilLoginButtonIsNotPresent() {
        waitHelper.waitUntilElementIsNotPresent(driver, loginButton, 10);
    }

    public void clickOnSavedEmail() {
        waitHelper.waitUntilElementIsVisible(driver, savedEmail, 5);
        waitHelper.waitUntilElementIsClickable(driver, savedEmail, 5);
        savedEmail.click();
    }
}

