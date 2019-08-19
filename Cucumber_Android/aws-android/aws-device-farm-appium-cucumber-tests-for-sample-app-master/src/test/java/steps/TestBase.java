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

package steps;

import pages.AcceptCookies;
import pages.RegisterOrLogin;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import pages.TermsAndConditions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */
public abstract class TestBase extends AbstractTestNGCucumberTests {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    public static AndroidDriver<MobileElement> driver;
    private  TermsAndConditions termsAndConditions;
    private RegisterOrLogin registerOrLogin;
    private AcceptCookies  acceptCookies;
    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
    public abstract String getName();

    /**
     * A pages containing the navigation drawer
     */


    /**
     * This method runs before any other method.
     * <p>
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     * <p>
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */

     void setUpAppium() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Set the DesiredCapabilities capabilities only for local development
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Demo16");
        capabilities.setCapability("appPackage", "com.daimler.mercedespay.android.stg");
        capabilities.setCapability("appActivity", "com.daimler.mercedespay.android.ui.splashscreen.SplashScreenActivity");
        capabilities.setCapability("udid", "5200c539fa4d749d");
        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver<MobileElement>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.resetApp();
    }

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium() {
        driver.quit();
    }

    /**
     * Creates a navigation pages and navigates to the Class' category
     * within the navigation drawer
     */

    void navigateTo() throws InterruptedException {
        termsAndConditions = new TermsAndConditions(driver);
        termsAndConditions.gotoCategory(getName());
        registerOrLogin = new RegisterOrLogin(driver);
        registerOrLogin.selectLogin();
        acceptCookies = new AcceptCookies(driver);
        acceptCookies.continueCookies();
    }

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
////     */
    @AfterClass
    public void restartApp() {
        driver.resetApp();
        driver.quit();
    }
}