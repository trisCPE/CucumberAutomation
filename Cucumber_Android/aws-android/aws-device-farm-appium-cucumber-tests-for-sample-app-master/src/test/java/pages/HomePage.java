/*
 * Author: Tristan GUENEAU
 * All the logic on the home page is performed.
 *
 *
 */

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class HomePage extends BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private BanksAndCards banksAndCards = new BanksAndCards(driver);
    private static long startTime;
    private static long endTime;

    public String getSubBalance() {
        return subBalance.getText();
    }

    /**
     * The text below balance
     */
    @AndroidFindBy(id = "tv_balance_sub_message")
    private MobileElement subBalance;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Overview\")")
    private MobileElement ovButton;

    /**
     * The sideButton menu
     */
    @AndroidFindBy(id = "action_bar_btn_left")
    private MobileElement sideButton;

    /**
     * All the tabs button in the side menu
     */

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Banks & cards\")")
    private MobileElement BCButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Transactions\")")
    private MobileElement TrButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Security\")")
    private MobileElement SecurityButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Withdrawal\")")
    private MobileElement WithdrawalButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"About Mercedes pay\")")
    private MobileElement AboutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"App permissions\")")
    private MobileElement AppButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Customer Support\")")
    private MobileElement CSButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"FAQs\")")
    private MobileElement FAQButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Cookies Policy\")")
    private MobileElement CPButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"General Terms & Conditions\")")
    private MobileElement TandCButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Privacy Statement\")")
    private MobileElement PSButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Home\")")
    private MobileElement HomeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Vouchers\")")
    private MobileElement VouchersButton;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Stay tuned!\")")
    private MobileElement vouchersText;

    @AndroidFindBy(id = "tv_edit_personal_data")
    private MobileElement EditButton;

    @AndroidFindBy(id = "tv_logout")
    private MobileElement logoutButton;

    @AndroidFindBy(id = "fab")
    private MobileElement fabButton;

    @AndroidFindBy(id = "fab_direct_pay")
    private MobileElement directPay;

    @AndroidFindBy(id = "fab_pay")
    private MobileElement btnPay;

    @AndroidFindBy(id = "fab_top_up")
    private MobileElement topUp;

    @AndroidFindBy(id = "fab_send_money")
    private MobileElement sendMoney;

    @AndroidFindBy(id = "fab_cash_in")
    private MobileElement cash_in;

    @AndroidFindBy(id = "ib_actionbar_btn_i")
    private MobileElement infoBtn;

    @AndroidFindBy(id = "message")
    private MobileElement logoutMessage;

    @Getter
    @AndroidFindBy(id = "tv_transaction_amount")
    private MobileElement amount;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Anonymous\")")
    private MobileElement anonymousTransaction;


    private  Map<String, MobileElement> buttonsMap = new HashMap<>();
    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Pressing the collapse button on the left side and check every time if "Logout" is displayed
     *
     */
    public void pressSideButton(){
        Dimension dimensions = driver.manage().window().getSize();
        int scrollStart = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);

        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(sideButton));
        sideButton.click();


        /**Always reset side menu to the top*/
        try {
            logoutButton.isDisplayed();
        } catch (Exception e1) {
            System.err.println("Logout button not displayed ! Scroll to the top");
            driver.swipe(50, scrollEnd, 50, scrollStart, 300);
            driver.swipe(50, scrollEnd, 50, scrollStart, 300);
            try {
                logoutButton.isDisplayed();
            } catch (Exception e2) {
                System.err.println("Logout button not displayed ! Scroll to the top");
                driver.swipe(50, scrollEnd, 50, scrollStart, 300);
                driver.swipe(50, scrollEnd, 50, scrollStart, 300);
                try {
                    logoutButton.isDisplayed();
                } catch (Exception e3) {
                    System.err.println("Logout button not displayed ! Scroll to the top");
                    driver.swipe(50, scrollEnd, 50, scrollStart, 300);
                    driver.swipe(50, scrollEnd, 50, scrollStart, 300);
                    logoutButton.isDisplayed();
                }
            }
        }
    }

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

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        wait.until(ExpectedConditions.visibilityOf(subBalance));
        return subBalance.getText();
    }

    /**
     * Scroll until the withdrawal button is displayed
     */
    public void scrollMenu() {
        driver.scrollTo(WithdrawalButton.getText());
    }

    /**
     * Initialize the map containing the buttons
     */
    private void initMap() {
        buttonsMap.put("Edit personal data", EditButton);
        buttonsMap.put("Transactions", TrButton);
        buttonsMap.put("Banks & cards", BCButton);
        buttonsMap.put("Vouchers", VouchersButton);
        buttonsMap.put("Security", SecurityButton);
        buttonsMap.put("Withdrawal", WithdrawalButton);
        buttonsMap.put("About Mercedes pay", AboutButton);
        buttonsMap.put("App permissions", AppButton);
        buttonsMap.put("Customer Support", CSButton);
        buttonsMap.put("FAQs", FAQButton);
        buttonsMap.put("Cookies Policy", CPButton);
        buttonsMap.put("Information", infoBtn);
        buttonsMap.put("Logout", logoutButton);
        buttonsMap.put("Fab", fabButton);
        buttonsMap.put("Direct Pay", directPay);
        buttonsMap.put("FabPay", btnPay);
        buttonsMap.put("Top Up", topUp);
        buttonsMap.put("Send Money", sendMoney);
        buttonsMap.put("Cash In", cash_in);
        buttonsMap.put("Anonymous", anonymousTransaction);

    }

    /**
     * Waiting for the logout pop-up to be displayed
     */
    public void waitLogout() {
        boolean found = false;
        WebDriverWait wait = new WebDriverWait(this.driver, 60);

        do {
                try {
                    wait.until(ExpectedConditions.visibilityOf(logoutMessage));
                    found = true;
                    System.out.println("Pop up message found !");
                } catch (Exception e) {
                    System.err.println("Pop up message not found !");
                }
            } while (!found);

        }

    /**
     * True if the logout pop-up is displayed between 594 and 606 seconds(10min)
     * @param ctime
     * @return
     */
    public boolean compareTimers(Float ctime) {
        Float runTime;
        runTime= (float) (endTime - startTime) / 1000; //convert to seconds
        return ((runTime > ctime * 0.99) || (runTime < ctime * 1.01));
    }


    public void setStartTime() throws Throwable {
        startTime = System.currentTimeMillis();
    }

    public void setEndTime() throws Throwable {
        endTime = System.currentTimeMillis();
    }

    /**
     * Swipe horizontally
     */
    public void horizontalScroll () {
        Dimension dim = driver.manage().window().getSize();
        int y = (int) (dim.getHeight()*0.50);
        int scrollStart = (int) (dim.getWidth()*0.75);
        int scrollEnd = (int) (dim.getWidth()*0.45);
        driver.swipe(scrollStart, y, scrollEnd, y, 300);
    }

}