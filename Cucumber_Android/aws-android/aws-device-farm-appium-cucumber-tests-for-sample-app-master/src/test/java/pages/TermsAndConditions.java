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
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

/**
 * A pages for navigation drawer
 */
public class TermsAndConditions extends BasePage{

    /**
     * Get the accept button
     */

    @AndroidFindBy(id = "id_TOUButtonsLayout_Button_Accept")
    private WebElement accept;

    public TermsAndConditions(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Go to a specific category within the navigation drawer
     *
     * @param endOfPage area
     */
    public void gotoCategory(String endOfPage) {

        //Doesn't always work. It seems to find the element even if it's not in view.
        //driver.scrollTo(endOfPage);

        Dimension dimensions = driver.manage().window().getSize();
        int scrollStart = (int) (dimensions.getHeight() * 0.5);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);

        boolean acceptEnabled = driver.findElementById("id_TOUButtonsLayout_Button_Accept").isEnabled();

        while (!acceptEnabled) {
            driver.swipe(50,scrollStart,50,scrollEnd,300);
            driver.swipe(50,scrollStart,50,scrollEnd,300);
            acceptEnabled = driver.findElementById("id_TOUButtonsLayout_Button_Accept").isEnabled();
        }
        accept.click();
    }





}
