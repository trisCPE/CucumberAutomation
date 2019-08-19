package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CustomerSupport extends BasePage {

    @AndroidFindBy(id="tv_heading")
    private MobileElement title;


    public String getCSHeader() {
        return title.getText();
    }

    public CustomerSupport(AppiumDriver driver) {
        super(driver);
    }
}
