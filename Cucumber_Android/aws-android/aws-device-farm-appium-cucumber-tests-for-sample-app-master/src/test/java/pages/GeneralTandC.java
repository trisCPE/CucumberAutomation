package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GeneralTandC extends BasePage {

    @AndroidFindBy(xpath = "//*[text()[contains(.,General Terms and Conditions)]]")
    private MobileElement generalTandC;

    public GeneralTandC(AppiumDriver driver) {
        super(driver);
    }

    public String getTandC() {
        return generalTandC.getText();
    }
}
