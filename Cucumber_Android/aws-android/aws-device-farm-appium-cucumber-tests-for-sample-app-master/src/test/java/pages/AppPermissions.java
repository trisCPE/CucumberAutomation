package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AppPermissions extends BasePage {

    @AndroidFindBy(id="tvTitle")
    private MobileElement title;

    public String getPermissions() {
        return title.getText();
    }

    public AppPermissions(AppiumDriver driver) {
        super(driver);
    }
}
