package com.ecommerce.automation.TestRunners;

import com.ecommerce.automation.Utilities.BaseUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseUtilities {

    @Before
    public void loadEnvProp(Scenario scenario) {
        loadingPropFile(scenario);
    }

    @io.cucumber.java.Before("@UITest")
    public void beforeScenario() {
        createWebDriver();
    }

    @After("@UITest")
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
