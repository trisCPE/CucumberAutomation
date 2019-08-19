/*
 * Author: Tristan GUENEAU
 * This page is accessible by clicking on the information icon on the top right corner of the window.
 *
 */



package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Information extends BasePage{

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Provider\")")
    private MobileElement providerTitle;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"App Description\")")
    private MobileElement appDescription;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Terms of Use\")")
    private MobileElement termsOfUse;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Data Protection\")")
    private MobileElement dataProtection;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Free & Open Source Software\")")
    private MobileElement freeOS;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Third Party Content\")")
    private MobileElement thirdPContent;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Legal Notices\")")
    private MobileElement legalNotices;


    @AndroidFindBy(className = "android.widget.Button")
    private List<WebElement> tabs;

    private Map<String, MobileElement> tabsMap = new HashMap<>();

    public String getProvider() {
        return providerTitle.getText();
    }

    public Information(AppiumDriver driver) {
        super(driver);
    }

    public void pressTab(int index) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(tabs.get(index)));
        tabs.get(index).click();
    }

    public void scrollMenu() {
        driver.scrollTo(tabs.get(3).getText());
    }
}
