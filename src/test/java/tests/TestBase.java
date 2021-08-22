package tests;

import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testData.EmployeesPageTestData;
import testData.LoginTestData;

public class TestBase {

    public static WebDriver driver;
    public static HrmLoginPage loginPage;
    public static WaitHelper waitHelper;
    public static UtilsPage utils;
    public static HrmEmployeesPage employeesPage;
    public static QuickMenu quickMenu;
    public static HrmProfilePage hrmProfilePage;
    public static EmployeesPageTestData employeesPageTestData;
    public static LoginTestData loginTestData;

    @BeforeTest
    public void navigateToHrmApp() {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new HrmLoginPage(driver);
        waitHelper = new WaitHelper();
        employeesPage = new HrmEmployeesPage(driver);
        utils = new UtilsPage();
        quickMenu = new QuickMenu(driver);
        hrmProfilePage = new HrmProfilePage(driver);
        employeesPageTestData = new EmployeesPageTestData();
        loginTestData = new LoginTestData();


    }
   @AfterTest
    public void tearDown() {

        driver.quit();
    }

}
