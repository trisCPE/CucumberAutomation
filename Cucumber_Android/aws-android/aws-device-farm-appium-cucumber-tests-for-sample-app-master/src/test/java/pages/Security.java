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

public class Security extends BasePage {

    @Getter
    @AndroidFindBy(id="tv_header")
    private MobileElement securityHeader;


    @AndroidFindBy(id="btn_change_password_text")
    private MobileElement btnchangePwd;


    @AndroidFindBy(id="btn_clear_cookies_text")
    private MobileElement btnClear;


    @AndroidFindBy(id="button1")
    private MobileElement btn_yes;


    @AndroidFindBy(id="button2")
    private MobileElement btn_no;

    @AndroidFindBy(id="tv_heading")
    private MobileElement changePwd;

    @AndroidFindBy(className="android.widget.EditText")
    private List<MobileElement> fields;

    @AndroidFindBy(id="et_customedit_input")
    private MobileElement inputPwd;

    @Getter
    @AndroidFindBy(id="alert_title")
    private MobileElement alertTitle;

    @AndroidFindBy(id="iv_result_icon")
    private MobileElement validationIcon;

    @Getter
    @AndroidFindBy(id="btn_save")
    private MobileElement saveButton;

    @AndroidFindBy(className="android.widget.Button")
    private List<MobileElement> btnList;

    @Getter
    @AndroidFindBy(id="tv_customedit_message")
    private MobileElement errorPwd;

    private  Map<String, MobileElement> buttonsMap = new HashMap<>();
    public Security(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Press button whose name is retrieved from the buttons map
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        initMap();
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
        buttonsMap.get(buttonText).click();
    }

   public String getHeading(){ return changePwd.getText(); }

   public boolean isIconDisplayed(){
        return validationIcon.isDisplayed();
   }

    /**
     * Press buttons show/hide one after each other depending on their position
     * @param number
     * @param buttonToPress
     */
    public void pressButtonNr(int number, String buttonToPress) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        if(buttonToPress.equals("Show") || buttonToPress.equals("Hide"))
            wait.until(ExpectedConditions.visibilityOf(btnList.get(number)));
            btnList.get(number).click();
    }

    /**
     * Assert the password is visible after pressing show
     * @param position
     */
    public void seePwd(int position) {
        Assert.assertEquals(fields.get(position).getAttribute("password"), "false"); } //we see the password in clear

    /**
     * Assert the password is hidden after pressing hide
     * @param position
     */
    public void notSeePwd(int position) {
        Assert.assertEquals(fields.get(position).getAttribute("password"), "true"); //we see the hidden password
    }

    /**
     * Type in the passwords dynamically in the change password page
     * @param pwd
     */
    public void typeIn(String pwd) {
            if (fields.get(0).getAttribute("focused").equals("true")) {
                fields.get(0).clear();
                fields.get(0).sendKeys(pwd + "\n");
                driver.hideKeyboard();
                fields.get(1).click(); //focus the next input field
            }
            else if(fields.get(1).getAttribute("focused").equals("true")) {
                fields.get(1).clear();
                fields.get(1).sendKeys(pwd + "\n");
                driver.hideKeyboard();
            }
            else{
                fields.get(2).clear();
                fields.get(2).sendKeys(pwd + "\n");
                driver.hideKeyboard();
            }
    }

    /**
     * Initialize the map containing buttons
     */
    private void initMap() {
        buttonsMap.put("Change password", changePwd);
        buttonsMap.put("Clear cookies", btnClear);
        buttonsMap.put("No", btn_no);
        buttonsMap.put("EditSave", saveButton);
    }
}
