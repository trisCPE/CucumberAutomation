package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transactions extends BasePage {

    @Getter
    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    /**
     * The sideButton menu
     */
    @AndroidFindBy(id = "action_bar_btn_left")
    private MobileElement sideButton;

    @AndroidFindBy(id = "btn_reservation_learn_more_empty")
    private MobileElement resButton;


    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<MobileElement> transactions;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Home\")")
    private MobileElement homeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Paid\")")
    private MobileElement paidButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Received\")")
    private MobileElement receivedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Reserved\")")
    private MobileElement reservedButton;

    @AndroidFindBy(id="tv_transaction_destination")
    private List<MobileElement> trDestinations;
    private  Map<String, MobileElement> buttonsMap = new HashMap<>();
    WebDriverWait wait = new WebDriverWait(this.driver, 30);



    public Transactions(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Pressing available buttons in Transactions page
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        initMap();
        wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
        buttonsMap.get(buttonText).click();
    }

    /**
     * Check whether a tab is selected or not
     * @param tab
     */
    public void seeIsSelected(String tab) {
        if(tab.equals("Paid"))
            Assert.assertTrue(paidButton.isSelected(), "ERROR: Paid button is not selected !");
        if(tab.equals("Received"))
            Assert.assertTrue(receivedButton.isSelected(), "ERROR: Received button is not selected !");
        if(tab.equals("Reserved"))
            Assert.assertTrue(reservedButton.isSelected(), "ERROR: Reserved button is not selected !");
    }

    /**
     * Scrolling to the bottom
     */
    public void scrollMenu() {
        System.out.println(trDestinations.get(3).getText());
        driver.scrollTo(trDestinations.get(3).getText());
    }


    /**
     * Initialize the map containing buttons
     */
    private void initMap() {
        buttonsMap.put("Home", homeButton);
        buttonsMap.put("Paid", paidButton);
        buttonsMap.put("Received" , receivedButton);
        buttonsMap.put("Reserved" , reservedButton);

    }
}
