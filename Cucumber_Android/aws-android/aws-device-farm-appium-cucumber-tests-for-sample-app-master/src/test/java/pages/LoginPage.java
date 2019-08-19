/*
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

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * A login pages
 */
public class LoginPage extends BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private RegisterOrLogin registerOrLogin;

    /**
     * The login button
     */
    @AndroidFindBy(id = "btn_login")
    private MobileElement loginButton;

    /**
     * The user name input
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    private MobileElement usernameField;

    /**
     * The password input
     */
    @AndroidFindBy(xpath = "//android.widget.EditText[@password='true']")
    private MobileElement passwordField;

    @AndroidFindBy(id="message")
    private MobileElement incorrectMessage;


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tries to login with a set of credentials
     *
     * @param username the username
     * @param password the password
     *
     * @return true if username was entered in correctly, else false.
     */
    public boolean login(String username, String password) throws InterruptedException {
        registerOrLogin = new RegisterOrLogin(driver);
        registerOrLogin.selectLogin();

        usernameField.clear();
        boolean usernameStatus = sendKeysToElement(username, usernameField, false);

        passwordField.clear();
        passwordField.sendKeys(password);

        driver.hideKeyboard();
        loginButton.click();

        return usernameStatus;
    }



    public String getLogin() {
        return loginButton.getText();
    }

    public String getMessage() {
        return incorrectMessage.getText();
    }

    /**
     * Checks to see if back at login pages
     *
     * @return is back at login
     */
    public boolean checkIfBackAtLogin() {
        return loginButton.isDisplayed() && usernameField.isDisplayed() && passwordField.isDisplayed();
    }

    /**
     * Presses the logout/try again button
     */
    public void pressOk() {
        driver.findElementById("button1").click();
    }
}
