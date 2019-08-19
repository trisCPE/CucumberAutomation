package pages.PaymentMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopUp extends BasePage {

    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    @Getter
    @AndroidFindBy(id="btn_ok")
    private MobileElement okButton;

    @AndroidFindBy(id="iv_card_check")
    private List<WebElement> cardList;

    @AndroidFindBy(id="iv_bank_check")
    private MobileElement bankList;

    @AndroidFindBy(id="cl_pay_button_asset")
    private MobileElement buttonMethods;

    @Getter
    @AndroidFindBy(id="tv_pay_paying_amount")
    private MobileElement amountHeader;

    @Getter
    @AndroidFindBy(id="tv_you_transfered")
    private MobileElement youTransfered;

    @AndroidFindBy(id="et_pay_amount")
    private MobileElement payAmount;

    @Getter
    @AndroidFindBy(id="tv_amount")
    private MobileElement tvAmount;

    private Map<String, MobileElement> buttonsMap = new HashMap<>();
    private WebDriverWait wait = new WebDriverWait(this.driver, 30);


    public TopUp(AppiumDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }


    /**
     * Press button whose name is retrieved from the buttons map
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        initMap();
        wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
        buttonsMap.get(buttonText).click();
    }

    /**
     * Select a payment method (either bank account or credit card)
     * @param methodName
     */
    public void chooseMethod(String methodName) {
        Dimension dimensions = driver.manage().window().getSize();
        int scrollStart = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);
        buttonMethods.click();

        if (methodName.equals("Bank account")) {
            while (!waitForPresence(30, "tv_bank_status")) {
                driver.swipe(50, scrollStart, 50, scrollEnd, 300);
                driver.swipe(50, scrollStart, 50, scrollEnd, 300);
            }
            bankList.click();
        }
        else {
            while (!waitForPresence(30, "tv_card_status")) {
                driver.swipe(50, scrollStart, 50, scrollEnd, 300);
                driver.swipe(50, scrollStart, 50, scrollEnd, 300);
            }
            cardList.get(0).click();
        }
    }

    /**
     * Waiting for an element to be displayed
     * @param timeLimitInSeconds
     * @param id
     * @return
     */
    public boolean waitForPresence( int timeLimitInSeconds, String id){
        try{
            MobileElement mobileElement =  (MobileElement) driver.findElementById(id);
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            boolean elementDisplayed = mobileElement.isDisplayed();
            return elementDisplayed;
        } catch(Exception e){
            boolean elementDisplayed = false;
            System.out.println(e.getMessage());
            return  elementDisplayed;
        }
    }

    /**
     * Typing some amount of money
     * @param amount
     */
    public void typeAmount(String amount) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(payAmount).perform();
        payAmount.sendKeys(amount);
        driver.hideKeyboard();
    }

    private void initMap() {
        buttonsMap.put("Ok", okButton);
    }
}
