package pages.PaymentMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class DirectPay extends BasePage {

    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    @AndroidFindBy(id="button1")
    private MobileElement cancelBtn;

    @Getter
    @AndroidFindBy(id="tv_pay_qrcode_title")
    private MobileElement payTitle;

    @Getter
    @AndroidFindBy(id="tv_directpay_limit")
    private MobileElement dPayLimit;
    private  Map<String, MobileElement> buttonsMap = new HashMap<>();

    public DirectPay(AppiumDriver driver) {
        super(driver);
    }
    public String getPay() {
        return title.getText();
    }

    /**
     * Pressing available buttons in Direct Pay page
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        initMap();
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
        buttonsMap.get(buttonText).click();
    }

    private void initMap() {
        buttonsMap.put("CANCEL", cancelBtn);
    }




}
