package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class About extends BasePage{

    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    public About(AppiumDriver driver) {
        super(driver);
    }
    public String getAboutMpay(){
        return title.getText();
    }
}
