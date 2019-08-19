/*
 * Author: Tristan GUENEAU
 * All the Complete Profile menu logic is performed
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
import java.util.Map;

public class CompleteProfile extends BasePage {

    @AndroidFindBy(id ="btnLater")
    private MobileElement btnLater;

    @AndroidFindBy(id ="btnAgree")
    private MobileElement btnAgree;

    @AndroidFindBy(id ="cbAgree")
    private MobileElement cbAgree;

    @AndroidFindBy(id ="vPaymentSection")
    private MobileElement paymentSection;

    @Getter
    @AndroidFindBy(id ="tvPaymentSectionTitle")
    private MobileElement sectionTitle;

    @AndroidFindBy(id ="tvNumber1Example")
    private MobileElement nbr1Example;

    @AndroidFindBy(id ="vVerificationSection")
    private MobileElement idSection;

    private Map<String, MobileElement> buttonsMap = new HashMap<>();
    WebDriverWait wait = new WebDriverWait(this.driver, 30);

    public CompleteProfile(AppiumDriver driver) {
        super(driver);
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
     * Scroll until the agree checkbox is displayed
     */
    public void tick() {
        wait.until(ExpectedConditions.visibilityOf(cbAgree));
        cbAgree.click();
    }

    /**
     * Scroll until the agree checkbox is displayed
     */
    public void scrollMenu() {
        driver.scrollTo(nbr1Example.getText());
    }


    /**
     * Initialize the map containing buttons
     */
    private void initMap() {
        buttonsMap.put("Later", btnLater);
        buttonsMap.put("I agree", btnAgree);
        buttonsMap.put("Payment method", paymentSection);
    }
}
