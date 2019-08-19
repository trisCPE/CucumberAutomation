package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyStatement extends BasePage {

   @AndroidFindBy(xpath = "//*[text()[contains(.,Privacy Statement)]]")
   private MobileElement privacyStatement;

    public PrivacyStatement(AppiumDriver driver) {
        super(driver);
    }

    public String getPSTitle() {
        return privacyStatement.getText();
    }


}