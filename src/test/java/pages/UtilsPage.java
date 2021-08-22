package pages;

import tests.TestBase;

import java.util.Set;

public class UtilsPage extends TestBase {

    String mainWindow = driver.getWindowHandle();

    public void navigateTo(String pageURL) {
        driver.get(pageURL);

    }

    public void switchToMainWindowHandler() {

        System.out.println("main window handler: " + mainWindow);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void switchToMainWindow() {
        driver.switchTo().window(mainWindow);
    }


}
