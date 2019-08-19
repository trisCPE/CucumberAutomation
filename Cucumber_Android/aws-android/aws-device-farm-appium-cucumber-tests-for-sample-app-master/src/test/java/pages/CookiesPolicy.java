package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesPolicy extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, 60);

    public CookiesPolicy(AppiumDriver driver) {
        super(driver);
    }

    public String getCP() {

        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Cookies Policy\")")));
        } catch (TimeoutException t) {
            System.err.println("The text Cookies Policy is not  present on this page");
        }
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Cookies Policy\")")).getText();
    }
}
