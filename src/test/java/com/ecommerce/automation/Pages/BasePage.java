package com.ecommerce.automation.Pages;

import com.ecommerce.automation.Utilities.BaseUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends BaseUtilities {
    public static final long TIMEOUT = 30;

    //Constructor
    public BasePage(WebDriver driver) {
        BaseUtilities.driver = driver;
    }

    public void isDisplayedThenClick(WebElement locator, String elementName) {
        if (locator.isDisplayed())
        {
            locator.click();
            logPass(elementName + " is Dispayed and Clicked on it");
        } else {
            logFail(elementName + " is Not Displayed");
        }
    }
}
