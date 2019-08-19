/*
 * AUTHOR : Tristan Gueneau
 *
 *
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package steps;

import commands.CreateButtonCommand;
import commands.CreateScrollCommand;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pages.*;
import pages.PaymentMethods.Pay;
import pages.PaymentMethods.TopUp;

public class LoginTest extends TestBase {
    private static final String LOGIN_SUCCESS_MESSAGE = "monthly limit";
    private static final String LOGIN_FAIL_MESSAGE = "Incorrect credentials";
    private static final String CORRECT_USER_NAME = "j09@moonlightservices.eu";
    private static final String NEW_PASSWORD = "Test@112233";
    private static final String CORRECT_PASSWORD = "Test@1122333";
    private static final String FAIL_USER_NAME = "wrong@mercedes-pay.com";
    private static final String FAIL_PASSWORD = "Test@11223344";
    private static final String BAD_TEXT_ENTRY_MSG = "Username sent to text field incorrectly";

    private LoginPage loginPage;
    private HomePage homePage;
    private BanksAndCards banksAndCards;
    private Security security;
    private Withdrawal withdrawal;
    private About about;
    /*The text below balance*/
    @AndroidFindBy(id = "tv_balance_sub_message")
    private MobileElement subBalance;

    /*This text is displayed at the bottom of T&C*/
    @Override
    public String getName() {
        return "Last update: May 2018";
    }


    @Given("^I am logged in$")
    public void isLogged() throws InterruptedException {
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getMessage(), LOGIN_SUCCESS_MESSAGE);
    }

    /**
     * Tests logging in with invalid credentials by verifying if the error message is correct
     */
    @Given("^username is bad$")
    public void loginFail() throws InterruptedException {
        Assert.assertTrue(loginPage.login(FAIL_USER_NAME, FAIL_PASSWORD));
        Assert.assertEquals(loginPage.getMessage(), LOGIN_FAIL_MESSAGE);
    }

    /**
     * Pressing the button whose name is passed in parameter
     * The client instantiate a createCommand invoker and calls the pressButton method
     * @param buttonToPress
     * @throws InterruptedException
     */
    @And("^I press button \"(.*)\"$")
    public void pressButton(String buttonToPress) throws InterruptedException {
        CreateButtonCommand invoker = new CreateButtonCommand();
        invoker.pressButton(buttonToPress);//Calling the invoker, this way the client is decoupled from the receivers(pages)
    }

    @When("^I scroll on the \"(.*)\" page$")
        public void iScroll(String destination) throws InterruptedException{
            CreateScrollCommand invoker = new CreateScrollCommand();
            invoker.scrollPage(destination);
        }

    @And("^I choose a (.*) payment method$")
    public void iChooseAPaymentMethod(String methodName) {
         TopUp topUp = new TopUp(driver);
         topUp.chooseMethod(methodName);
    }

    /**
     * Type in an amount of euro cents
     * @param amount
     */
    @And("^I type in amount \"(.*)\"$")
    public void iTypeAnTopUpAmountOfEuroCents(String amount) {
        TopUp topUp = new TopUp(driver);
        topUp.typeAmount(amount);
    }

    /**
     * Press the button show/hide for the passwords
     * @param index
     * @param buttonToPress
     */
    @And("^I press button number (\\d+) displaying \"(.*)\"$")
    public void iPressButtonNumberDisplaying(int index, String buttonToPress)  {
        Security security = new Security(driver);
        security.pressButtonNr(index, buttonToPress);
    }

    @And("^I start timer$")
    public void iStartTimer() throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.setStartTime();
    }

    @And("^I stop timer$")
    public void iStopTimer() throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.setEndTime();
    }

    @When("^I type \"(.*)\" as IBAN$")
        public void typeIBAN(String iban) {
        banksAndCards = new BanksAndCards(driver);
        banksAndCards.typeIBAN(iban);
    }

    /**
     * After each test method, logout or try again
     */
    @Then("^press ok$")
    public void pressOk() {
        loginPage.pressOk();
        Assert.assertTrue(loginPage.checkIfBackAtLogin());
    }

    @And("^I press tab with index (\\d+)$")
    public void iPressTabWithIndex(int number){
        Information information = new Information(driver);
        information.pressTab(number);
    }

    @And("^I tick the (.*) checkbox$")
    public void iTickTheCheckbox(String cbName) {
        if (cbName.equals("Make default")) {
            BanksAndCards banksAndCards = new BanksAndCards(driver);
            banksAndCards.makeDefault();
        }
        if (cbName.equals("Agree")) {
            CompleteProfile completeProfile = new CompleteProfile(driver);
            completeProfile.tick();
        }

    }

    /**
     * Type in some text in an input depending on which page the user currently is
     * @param textTotype
     */
    @And("^I type in \"(.*)\"$")
    public void iTypeIn(String textTotype)  {
        Security security = new Security(driver);
        Pay pay = new Pay(driver);
        EditData editData = new EditData(driver);
        try {
            driver.findElementById("action_bar_title");
            pay.typeIn(textTotype);
        } catch (Exception e) {
            try {
                driver.findElementById("tv_first_name"); //On the edit personal data page
                editData.typeIn(textTotype);
            } catch(Exception e2) {
                security.typeIn(textTotype);
            }
        }
    }

    /**
     * Scrolling horizontally from left to right
     */
    @When("^I scroll horizontally$")
    public void iScrollHorizontally() {
        HomePage homePage = new HomePage(driver);
        homePage.horizontalScroll();

    }
}
