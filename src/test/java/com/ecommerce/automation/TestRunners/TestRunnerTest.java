package com.ecommerce.automation.TestRunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static com.ecommerce.automation.Utilities.Constants.*;

    /*
     * JUnit Test Runner Changes implementation:
     * For eg: Change Feature file path settings as necessary for execution
     */

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {FEATURES_DIR},
            glue = {STEP_DEFINITIONS_DIR},
            tags = "@UITest",
            plugin = {"html:target/cucumber-report.html" , "io.qameta.allure.cucumber6jvm.AllureCusumber6Jvm"}
    )
    public class TestRunnerTest {
    }

