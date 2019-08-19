package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Vouchers extends BasePage{

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"No vouchers at the moment\")")
    private MobileElement VouchersText;


    public Vouchers(AppiumDriver driver) {
        super(driver);
    }

    public String getVouchers() {
        return VouchersText.getText();
    }

}
