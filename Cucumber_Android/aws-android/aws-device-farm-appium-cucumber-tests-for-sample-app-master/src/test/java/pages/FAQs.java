package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FAQs extends BasePage  {

    @AndroidFindBy(xpath="//*[@text='Select a topic']")
    private MobileElement header;


    public FAQs(AppiumDriver driver) {
        super(driver);
    }
    public String getHeader() {
        return header.getText();
    }
}
