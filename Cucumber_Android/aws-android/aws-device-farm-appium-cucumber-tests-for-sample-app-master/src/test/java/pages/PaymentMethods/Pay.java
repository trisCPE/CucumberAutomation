package pages.PaymentMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class Pay extends BasePage {

    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    @AndroidFindBy(id="et_pay_amount")
    private MobileElement payAmount;

    @AndroidFindBy(id="btn_pay")
    private MobileElement btnPay;

    @AndroidFindBy(id="button2")
    private MobileElement continueBtn;

    @AndroidFindBy(id="action_bar_btn_right")
    private MobileElement closeBtn;

    @Getter
    @AndroidFindBy(id="btn_pay_add_note")
    private MobileElement btnAddNote;

    @AndroidFindBy(id="btn_pay_remove_note")
    private MobileElement btnRemoveNote;

    @AndroidFindBy(id="btn_save")
    private MobileElement btnSave;

    @AndroidFindBy(id="et_note")
    private MobileElement inputNote;

    @AndroidFindBy(id="tv_pay_note")
    private MobileElement payNote;

    @Getter
    @AndroidFindBy(id="tv_pay_amount")
    private MobileElement payAmountHeader;

    @Getter
    @AndroidFindBy(id="tv_pay_amount_value")
    private MobileElement amountValue;

    @Getter
    @AndroidFindBy(id="tv_pay_qrcode_title")
    private MobileElement payTitle;

    private  Map<String, MobileElement> buttonsMap = new HashMap<>();
    private WebDriverWait wait = new WebDriverWait(this.driver, 30);
    public static AndroidDriver androidDriver;

    public Pay(AppiumDriver driver) {
        super(driver);
    }

    public String getPay() {
        return title.getText();
    }


    /**
     * Press button whose name is retrieved from the buttons map
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        initMap();
        if(buttonText.equals("Pay")){
            driver.hideKeyboard();  //Necessary because the keyboard appears each time the page is displayed
            buttonsMap.get(buttonText).click();
        }
        else if (buttonText.equals("QR Code")) {
            try {
                System.out.println("Pressing QR Code");
                System.out.println(androidDriver.findElementsByClassName("android.widget.ImageView").size());
            } catch (Exception e) {
                try {
                    System.out.println("Pressing full QR Code");
                } catch (Exception e1) {
                    System.err.println("The QR Code was not found");
                }
            }
        }
        else {
            System.out.println("Here for clicking on close button");
            wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
            buttonsMap.get(buttonText).click();
        }
    }

    private void initMap() {
        buttonsMap.put("Add comment", btnAddNote);
        buttonsMap.put("Remove comment", btnRemoveNote);
        buttonsMap.put("Pay", btnPay);
        buttonsMap.put("Save", btnSave);
        buttonsMap.put("Close button", closeBtn);
        buttonsMap.put("CONTINUE", continueBtn);
    }

    public void typeIn(String textToType) {
        wait.until(ExpectedConditions.visibilityOf(inputNote));
        inputNote.clear();
        inputNote.sendKeys(textToType + "\n");
        driver.hideKeyboard();
    }
}
