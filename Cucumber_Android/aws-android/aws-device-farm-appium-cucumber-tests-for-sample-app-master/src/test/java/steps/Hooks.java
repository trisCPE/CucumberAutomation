package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static steps.Log.testFailed;

public class Hooks extends TestBase {

    private LoginPage loginPage;
    private static final String CORRECT_USER_NAME = "jtime002+1@gmail.com";
    private static final String CORRECT_PASSWORD = "Test@112233";
    private static boolean firstRun = true;

    /*The text below balance*/
    @AndroidFindBy(id = "tv_balance_sub_message")
    private MobileElement subBalance;

    /*The text below balance*/
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Overview\")")
    private MobileElement overviewText;

    /**
     * Check if the application is on the home screen. Case not, launch the app
     * Executed before each scenario
     */
    @Before
    public void beforeScenario(Scenario scenario) throws Throwable {
        if(firstRun)
        {
            setUpAppium();
            navigateTo();
            firstRun = false; /* Ensure this is is only executed once */
        }
        try{
            Log.startTest(scenario.getName());
            driver.findElementById("tv_balance_sub_message");
        }catch (Exception e1){
            try{
                driver.findElementById("tv_lbl_login");
                loginSuccess();
            }catch(Exception e2) {
                try {
                    driver.launchApp();
                    driver.findElementById("tv_balance_sub_message");
                } catch (Exception e3) {
                    loginSuccess();
                }
            }
        }
    }

    /**
     * Reset to home view.
     * Executed after each scenario*
     */
    @After
    public void afterScenario(Scenario scenario) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        if(scenario.isFailed()) {
            testFailed();
            driver.closeApp(); /*Rather than reset for keeping the cache
                                 and restart from the login page*/
        }
        else{
                try {
                    Log.endTest();
                    wait.until(visibilityOf(driver.findElementById("tv_balance_sub_message")));
                }catch (Exception e1){
                    goBack();
                    try {
                        Thread.sleep(300);
                        driver.findElementById("tv_balance_sub_message");
                    }catch (Exception e2){
                        goBack();
                        try {
                            Thread.sleep(300);
                            driver.findElementById("tv_balance_sub_message");}
                        catch(Exception e3) {
                            goBack();
                            try {
                                Thread.sleep(300);
                                driver.findElementById("tv_balance_sub_message");
                            } catch (Exception e4) {
                                goBack();
                                try {
                                    driver.resetApp();
                                }catch (Exception e5) {}
                            }
                        }
                    }
                }
        }
    }

    private void goBack() {
        try {
            driver.findElementById("action_bar_btn_left");
            driver.findElementById("action_bar_btn_left").click();
            try {
                driver.findElementById("tv_logout");
                driver.findElementByAndroidUIAutomator("new UiSelector().textMatches(\"Home\")").click();
            } catch(Exception e1){}
        } catch (Exception e1) {
            try {
                driver.findElementById("action_bar_btn_right");
                driver.findElementById("action_bar_btn_right").click();
            } catch(Exception e2){
                try{
                    driver.findElementById("btn_left");
                    driver.findElementById("btn_left").click();
                } catch(Exception e3){
                    driver.resetApp();
                }
            }
        }
    }

    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     */
    @Given("^I login with correct username$")
    public void loginSuccess() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.login(CORRECT_USER_NAME, CORRECT_PASSWORD));
    }

    @Override
    public String getName() {
        return null;
    }
}
