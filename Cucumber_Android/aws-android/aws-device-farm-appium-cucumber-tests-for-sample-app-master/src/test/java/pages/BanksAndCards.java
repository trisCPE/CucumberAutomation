/*
 * Author: Tristan GUENEAU
 * All the Banks and Cards menu logic is performed
 *
 */

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BanksAndCards extends BasePage {

    @AndroidFindBy(id="action_bar_btn_right")
    private MobileElement buttonRight;

    @AndroidFindBy(id = "button1")
    private MobileElement button1;

    @AndroidFindBy(id = "button2")
    private MobileElement button2;

    @AndroidFindBy(xpath = "//*[@text='CANCEL']")
    private MobileElement cancelBtn;

    @AndroidFindBy(id="btn_enter_verification")
    private MobileElement btnVerfication;

    @AndroidFindBy(id="btnAddIbanNext")
    private MobileElement nextButton;

    @AndroidFindBy(id="btnFinish")
    private MobileElement finishButton;

    @Getter
    @AndroidFindBy(id="action_bar_title")
    private MobileElement title;

    @AndroidFindBy(id="action_bar_btn_left")
    private MobileElement prevButton;

    @AndroidFindBy(id="cbPaymentPref")
    private MobileElement checkbox;

    @AndroidFindBy(id="cb_payment_pref")
    private MobileElement checkboxBorC;

    @Getter
    @AndroidFindBy(id="tv_verification_state")
    private MobileElement defaultMessage;

    @Getter
    @AndroidFindBy(id="et_customedit_input")
    private MobileElement inputIBAN;

    @Getter
    @AndroidFindBy(id="alertTitle")
    private MobileElement alertTitle;

    @AndroidFindBy(id="tvSepaDdMandate")
    private MobileElement sepaButton;

    @Getter
    @AndroidFindBy(id = "cl_white_rect")
    private MobileElement boxText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Accepted credit cards\")")
    private WebElement acceptedCC;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"BELFIUS BANK\")")
    private MobileElement belfiusBA;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Fortuna Banque s.c.\")")
    private MobileElement fortunaBA;

    @AndroidFindBy(id = "rl_content")
    private List<WebElement> assetsList;

    @AndroidFindBy(id = "rlCountriesButton")
    private MobileElement countriesBtn;

    @AndroidFindBy(id = "search_src_text")
    private MobileElement searchInput;

    @AndroidFindBy(id = "tv_country")
    private MobileElement tvCountry;

    @Getter
    @AndroidFindBy(id = "tv_customedit_message")
    private MobileElement ibanInvalid;

    @Getter
    @AndroidFindBy(id = "btn_add_item")
    private MobileElement btnAddItem;



    WebDriverWait wait = new WebDriverWait(this.driver, 30);
    private  Map<String, MobileElement> buttonsMap = new HashMap<>();

    public BanksAndCards(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Press button whose name is retrieved from the buttons map
     * @param buttonText
     */
    public void pressButton(String buttonText){
        initMap();
        wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
        buttonsMap.get(buttonText).click();
    }

    /**
     * Type the IBAN and tick the checkbox
     * @param iban
     */
    public void typeIBAN(String iban) {
        inputIBAN.clear();
        inputIBAN.sendKeys(iban);
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();//Agree to sepa
    }

//    public String getTitle(){
//        return title.getText();
//    }

    /*Don't work!*/
//    public String getAcceptedCC() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("credit-card-number")));
//        return driver.findElement(MobileBy.id("credit-card-number")).getText();
//    }

    /**
     * Check whether country is displayed after research
     * @param countryName
     * @return
     */
    public boolean checkCountry(String countryName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();
        searchInput.sendKeys(countryName);
        driver.hideKeyboard();
        return tvCountry.isDisplayed();
    }

    /**
     * Make a method default
     */
    public void makeDefault() {
        wait.until(ExpectedConditions.visibilityOf(checkboxBorC));
        checkboxBorC.click();
    }

    /**
     * Initialize the map containing buttons
     */
    private void initMap() {
        buttonsMap.put("BELFIUS BANK", belfiusBA);
        buttonsMap.put("Enter your verification code", btnVerfication);
        buttonsMap.put("Delete",buttonRight);
        buttonsMap.put("Fortuna Banque s.c.", fortunaBA);
        buttonsMap.put("Cancel", cancelBtn);
        buttonsMap.put("Add", buttonRight);
        buttonsMap.put("BANK ACCOUNT", button1);
        buttonsMap.put("CREDIT CARD", button2);
        buttonsMap.put("DELETE", button1);
        buttonsMap.put("SEPA DD Mandate", sepaButton);
        buttonsMap.put("Finish", finishButton);
        buttonsMap.put("Accepted countries",countriesBtn);
        buttonsMap.put("Add bank account",btnAddItem);
    }
}
