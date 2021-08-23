package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import tests.TestBase;

public class UtilsPage extends TestBase {

    String mainWindow = driver.getWindowHandle();

    public void navigateTo(String pageURL) {
        driver.get(pageURL);

    }

    public void switchToNewWindow() {

        System.out.println("main window handler: " + mainWindow);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void switchToMainWindow() {
        driver.switchTo().window(mainWindow);
    }

    public void actionsClick(WebElement element) {
        Actions ob = new Actions(driver);
        ob.moveToElement(element);
        ob.click(element);
        Action action = ob.build();
        action.perform();

    }

}
