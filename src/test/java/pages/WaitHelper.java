package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

public class WaitHelper {


    public Boolean waitUntilElementIsVisible(WebDriver driver, WebElement element, long seconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, seconds);

        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean waitUntilElementIsVisible(WebDriver driver, By locator, long seconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, seconds);

        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean waitUntilElementIsNotPresent(WebDriver driver, WebElement element, long seconds) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public Boolean waitUntilValueContains(WebDriver driver, WebElement element, long seconds, String attributeValue) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.textToBePresentInElementValue(element, attributeValue));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean waitUntilElementIsClickable(WebDriver driver, WebElement element, long seconds) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public Boolean waitUntilElementIsClickable(WebDriver driver, By locator, long seconds) {

        WebDriverWait wait = new WebDriverWait(driver, seconds);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public Boolean driverWait(WebDriver driver, long time) {
        try {
//            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
            Thread.sleep(time);
            return true;
        }catch (Exception e){
            return false;
        }

    }


}