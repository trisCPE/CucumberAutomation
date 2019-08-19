/*
 * AUTHOR : Tristan Gueneau
 * Steps containing assertions and hooks.
 *
 *
*/
package steps;

import com.google.common.collect.ImmutableMap;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BanksAndCards;
import pages.HomePage;
import pages.Security;
import pages.Transactions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class ResultSteps extends TestBase {

    private WebDriverWait wait = new WebDriverWait(driver, 30);


    @Override
    public String getName() {
        return null;
    }

    @Then("^I see title or header \"(.*)\"$")
    public void iSeeTitleOrHeader(String title) {
        Transactions transactions = new Transactions(driver);
        Assert.assertEquals(transactions.getTitle().getText(), title); //title has the same id in multiple pages
    }

//    @Then("^I see QR Code in full screen$")
//    public void iSeeQRCodeInFullScreen() {
//        Pay pay = new Pay(driver);
//        Assert.assertTrue(pay.getQrCodeFull().isDisplayed());
//    }

    @Then("^I do not see pop-up with header \"(.*)\"$")
    public void iDoNotSeePopUp() {
        Security security = new Security(driver);
        Assert.assertFalse(security.getAlertTitle().isDisplayed(), "ERROR: Pop-up is displayed !");
    }

    @Then("^I see pop-up with header \"(.*)\"$")
    public void iSeePopUp(String text) {
        Security security = new Security(driver);
        Assert.assertEquals(security.getAlertTitle().getText(), text, "ERROR : Pop-up is not displayed !");
    }

    /**
     * Check whether the blue validation icon is displayed or not
     */
    @Then("^I see the validation logo$")
    public void isValidated() {
        Security security = new Security(driver);
        Assert.assertTrue(security.isIconDisplayed());
    }

    @Then("^I see \"(.*)\" is selected$")
    public void iSeeIsSelected(String tab) {
        Transactions transactions = new Transactions(driver);
        transactions.seeIsSelected(tab);
    }

    @Then("^the button Save is disabled$")
    public void theButtonSaveIsDisabled() {
        Security security = new Security(driver);
        Assert.assertFalse(security.getSaveButton().isEnabled(), "Button save not disabled !");
    }

    @Then("^I see the country \"(.*)\" is accepted$")
    public void iCheckAllTheAcceptedCountries(String countryName) {
        BanksAndCards banksAndCards = new BanksAndCards(driver);
        Assert.assertTrue(banksAndCards.checkCountry(countryName), "Country not displayed !");
    }

    @Then("^I see the country \"(.*)\" is not accepted$")
    public void iSeeTheCountryIsNotAccepted(String countryName) {
        BanksAndCards banksAndCards = new BanksAndCards(driver);
        Assert.assertFalse(banksAndCards.checkCountry(countryName), "Country displayed !");
    }

    @Then("^I wait for logout pop-up$")
    public void iWaitForLogoutPopUp() {
        HomePage homePage = new HomePage(driver);
        homePage.waitLogout();
    }

    @Then("^I compare timers with \"([^\"]*)\"$")
    public void iCompareTimersWith(Float ctime) {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.compareTimers(ctime), "Pop-up not displayed when expected !");
    }

    @Then("^I see password number (\\d+)$")
    public void iSeePassword(int position) {
        Security security = new Security(driver);
        security.seePwd(position);
    }

    @Then("^I do not see password number (\\d+)$")
    public void iDoNotSeePasswordNumber(int position){
        Security security = new Security(driver);
        security.notSeePwd(position);
    }


    @Then("^flashlight is on$")
    public boolean flashlightIsOn() {
        //ADB command is dumpsys media.camera, then check for /device@1.0/legacy/0 and for flash-mode
        String AdbOutput;

        /*Preparing the JSON for sneding to the adb runner*/

        /*Writing the command argument, here get the state of the camera here*/
        List<String> CamArguments = Arrays.asList(
                "media.camera"
        );

        /*Writing the adb command: adb shell dumpsys and add its argument*/
        Map<String, Object> CamCmd = ImmutableMap.of(
                "command", "dumpsys",
                "args", CamArguments
        );

        /*Run the adb command and pars the result into a string*/
        AdbOutput = (String) driver.executeScript("mobile: shell", CamCmd);

        /*Check whether the Flashlight is on torch mode*/
        return (AdbOutput.contains("flash-mode: torch"));
    }

    /**
     * Seeing the text passed in parameter on a pages.
     * The client instantiate a createCommand invoker and calls the iSeeText method
     * @param expectedText
     */
    @Then("^I see text \"(.*)\"$")
    public void iSeeText(String expectedText) throws InterruptedException {
        try {
            wait.until(visibilityOf(driver.findElementByAndroidUIAutomator("new UiSelector().textMatches(\"" + expectedText + "\")")));
            Log.info("Text was found !");
        } catch (Exception t) {
            throw new InterruptedException("The text : " + expectedText + " is not displayed !!");
        }
    }

    /**
     * Seeing the text passed in parameter on a pages.
     * The client instantiate a createCommand invoker and calls the iSeeText method
     * @param expectedText
     */
    @Then("^I do not see text \"(.*)\"$")
    public void iDoNotSeeText(String expectedText) throws InterruptedException{
        try {
            wait.until(visibilityOf(driver.findElementByAndroidUIAutomator("new UiSelector().textMatches(\"" + expectedText + "\")")));
            Log.info("Text is not visible !");
        } catch (Exception t) {
            throw new InterruptedException("The text : " + expectedText + " is well displayed !!");
        }
    }

}
