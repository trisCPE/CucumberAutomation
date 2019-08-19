package pages.PaymentMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class CashIn extends BasePage {

    @Getter
    @AndroidFindBy(id="tv_kyc_intro_heading")
    private MobileElement cashIn;

    @Getter
    @AndroidFindBy(id="btn_later")
    private MobileElement btnNo;

    @AndroidFindBy(id="btn_accept")
    private MobileElement btnAccept;

    @AndroidFindBy(id="btn_agree")
    private MobileElement btnYes;

    @AndroidFindBy(id="btn_flashlight")
    private MobileElement btnFlashlight;

    private Map<String, MobileElement> buttonsMap = new HashMap<>();

    public CashIn(AppiumDriver driver) {
        super(driver);
    }

    public void pressButton(String buttonText) {
        initMap();
        if(buttonText.equals("Allow")){
            allowAppPermission();
        }
        else if (buttonText.equals("Deny")){
            denyAppPermission();
        }
        else {
            WebDriverWait wait = new WebDriverWait(this.driver, 30);
            wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
            buttonsMap.get(buttonText).click();
        }
    }

    /**
     * Allow app permission for accessing to camera
     */
    private void allowAppPermission() {
        try {
            System.out.println("Checking....");
            driver.findElement(MobileBy.xpath("//*[@text='ALLOW']")).isDisplayed();
            driver.findElement(MobileBy.xpath("//*[@text='ALLOW']")).click();
            }
        catch(Exception e){
            System.out.println("Not displayed !!!!!");
            }
     }
    /**
     * Deny app permission for accessing to camera
     */
    private void denyAppPermission() {
        try {
            System.out.println("Checking....");
            driver.findElement(MobileBy.xpath("//*[@text='DENY']")).isDisplayed();
            driver.findElement(MobileBy.xpath("//*[@text='DENY']")).click();
        }
        catch(Exception e){
            System.out.println("Not displayed !!!!!");
        }
    }
    /**
     * Initialize the map containing buttons
     */
    private void initMap() {
        buttonsMap.put("Flashlight", btnFlashlight);
        buttonsMap.put("Yes", btnYes);
    }

    /**
     * Check whether the flashlight is enabled
     * @return
     */
//    public boolean isFlashlightEnabled() {
//        Parameters parameters = Camera.Parameters;
//        System.out.println("Flash mode :" + parameters.getFlashMode());
//        return parameters.getFlashMode().equals("FLASH_MODE_ON");
//    }

}
