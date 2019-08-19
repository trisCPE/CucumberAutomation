package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class Withdrawal extends BasePage{

    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    @AndroidFindBy(id="action_bar_btn_right")
    private MobileElement quitButton;

    @Getter
    @AndroidFindBy(id="btn_bottom")
    private MobileElement bottomBtn;

    @AndroidFindBy(id="iv_result_icon")
    private MobileElement validationIcon;

    @AndroidFindBy(id="et_pay_amount")
    private MobileElement payAmount;

    @Getter
    @AndroidFindBy(id="textView4")
    private MobileElement selectBA;

    @Getter
    @AndroidFindBy(id="tv_amount_text")
    private MobileElement amountText;

    @Getter
    @AndroidFindBy(id="tv_asset_details")
    private MobileElement assetDetails;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"3464\")")
    private MobileElement bankAccount;
    private  Map<String, MobileElement> buttonsMap = new HashMap<>();

    public Withdrawal(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }
    public String getBA() {
        return bankAccount.getText();
    }

//    /**
//     * Type some amount
//     * @param amount
//     */
//    public void typeAmount(String amount) {
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.tap(payAmount).perform();
//        //Integer newAmount = amount * 100;
//        payAmount.sendKeys(amount);
//        driver.hideKeyboard();
//    }

    /**
     * Press the corresponding button whose name has been retrieved in the CommandButton class
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        initMap();
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
        buttonsMap.get(buttonText).click();
    }

    private void initMap() {
        buttonsMap.put("Ok", bottomBtn);
        buttonsMap.put("Ends with", assetDetails);
        buttonsMap.put("Next", bottomBtn);
    }
}
