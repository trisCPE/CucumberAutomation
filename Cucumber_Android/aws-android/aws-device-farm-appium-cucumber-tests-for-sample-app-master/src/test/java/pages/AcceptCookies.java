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
public class AcceptCookies extends BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;

    /**
     * The login button
     */
    @AndroidFindBy(id = "btn_accept")
    private MobileElement continueButton;

    /**
     * The user name input
     */
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/username_text_input")
    private MobileElement usernameField;

    /**
     * The password input
     */
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/password_text_input")
    private MobileElement passwordField;

    public AcceptCookies(AppiumDriver driver) {
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
    public void continueCookies() throws InterruptedException {
        continueButton.click();
    }


    /**
     *
     * @return the login message
     */
    public String getMessage() {
        return driver.findElementById("Alt Message").getText();
    }

    /**
     * Checks to see if back at login pages
     *
     * @return is back at login
     */
    //public boolean checkIfBackAtLogin() {
    //    return loginButton.isDisplayed() && usernameField.isDisplayed() && passwordField.isDisplayed();
    //}

    /**
     * Presses the logout/try again button
     */
    public void pressAltButton() {
        driver.findElementById("Alt Button").click();
    }
}
