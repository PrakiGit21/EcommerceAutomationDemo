package com.ecommerce.automation.Utilities;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUtilities implements Constants {

    /*
     * Initialization of Driver and Hooks Method Initialization goes here
     */

    public static WebDriver driver;
    public static String environment;
    public static Scenario scenario;
    public static Properties envConfig;
    public static Properties configProp = getProps(Constants.CONFIG_DIR, "config");

    public void loadingPropFile(Scenario scenario) {
       BaseUtilities.scenario = scenario;
       environment = System.getProperty("env" , "CONFIG");
       System.out.println("environment:" + environment);
       if (environment.equalsIgnoreCase("CONFIG")){
           envConfig = configProp;
       }
   }

   public void createWebDriver() {
       String webdriver = System.getProperty("browser", "chrome");
       try {
           if ("chrome".equals(webdriver)) {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               driver.manage().window().maximize();
               driver.manage().deleteAllCookies();
               driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
               return;
           } else if ("edge".equals(webdriver)) {
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
               driver.manage().window().maximize();
               driver.manage().deleteAllCookies();
               driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
               return;
           }
           throw new RuntimeException("Unsupported webdriver: " + webdriver);
   } catch (Exception e)
       {
           e.printStackTrace();
       }
   }

    public static Properties getProps(final String FILE_PATH, final String FILE_NAME) {
        Properties properties = null;
        try {
            File file = new File(FILE_PATH, FILE_NAME + ".properties");
            properties = new Properties();
            //Reading the properties file
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getPropValue(Properties properties, String key) {

       //Returing the Property value depends on the Key
        return properties.getProperty(key);
    }

    public void logPass(String msg) {
        {
            scenario.attach(msg, "text/plain" , msg);
        }
    }

    public void logFail(String msg) {
        {
            scenario.attach(msg, "text/plain" , msg);
            if(driver!=null) {
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Failed Screenshot");
            }
            Assert.fail(msg);
        }
    }

}
