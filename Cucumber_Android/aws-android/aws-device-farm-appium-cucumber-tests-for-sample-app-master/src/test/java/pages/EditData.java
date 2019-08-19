/*
 * AUTHOR : Tristan Gueneau
 *
 */
package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditData extends BasePage {

    @AndroidFindBy(id = "itemTitle")
    private List<MobileElement> titles;

    @Getter
    @AndroidFindBy(id = "action_bar_title")
    private MobileElement title;

    @Getter
    @AndroidFindBy(id = "tv_full_name")
    private MobileElement fullName;

    @AndroidFindBy(id="btn_left")
    private MobileElement prevButton;

    @AndroidFindBy(id="ll_profile_item")
    private List<MobileElement> tabs;

    @AndroidFindBy(id="et_customedit_input")
    private List<MobileElement> nameInputs;

    @Getter
    @AndroidFindBy(id="tv_customedit_message")
    private MobileElement errorMessage;

    @Getter
    @AndroidFindBy(id="message")
    private MobileElement message;

    @Getter
    @AndroidFindBy(id="button2")
    private MobileElement cancelBtn;

    @Getter
    @AndroidFindBy(id="button1")
    private MobileElement csBtn;

    @Getter
    @AndroidFindBy(id="btn_save")
    private MobileElement btnSave;

    private Map<String, MobileElement> buttonsMap = new HashMap<>();

    {
        buttonsMap.put("EditSave", btnSave);
        buttonsMap.put("Cancel_Edit", cancelBtn);
        buttonsMap.put("Support", csBtn);
    }


    public EditData(AppiumDriver driver){
        super(driver);
    }
    public String getName() {
        return fullName.getText();
    }

    /**
     * Press button whose name is retrieved from the buttons map
     * @param buttonText
     */
    public void pressButton(String buttonText) {
        if (buttonText.equals("Name")) {
            tabs.get(0).click(); //retrieving the Name button just when it is displayed
        }
        else if (buttonText.equals("Close account")) {
            tabs.get(2).click();
        }
        else {
            WebDriverWait wait = new WebDriverWait(this.driver, 30);
            wait.until(ExpectedConditions.visibilityOf(buttonsMap.get(buttonText)));
            buttonsMap.get(buttonText).click();
        }
    }

    /***
     * Type in the name and surname
     * @param textToType
     */
    public void typeIn(String textToType) {
        if (isFocused(nameInputs.get(0))) {
            nameInputs.get(0).clear();
            nameInputs.get(0).sendKeys(textToType + "\n");
        }
        else{
            nameInputs.get(1).clear();
            nameInputs.get(1).sendKeys(textToType);
            driver.hideKeyboard();
        }
    }


    private boolean isFocused(MobileElement element) {
        return element.getAttribute("focused").equals("true");
    }


    /**
     * Scrolling to the bottom
     */
    public void scrollMenu() {
            System.out.println("Size of titles : " + titles.size());
            driver.scrollTo(titles.get(3).getText());
    }
}
