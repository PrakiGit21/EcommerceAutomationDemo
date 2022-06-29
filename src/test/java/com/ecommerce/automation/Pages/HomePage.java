package com.ecommerce.automation.Pages;

import com.ecommerce.automation.Utilities.BaseUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);

    public void navigateToApplicationUrl() {
        String applicationURL = getPropValue(configProp, "ApplicationBaseURL");
        driver.get(applicationURL);
    }

    @FindBy (xpath = "//a[text()='Cart']")
    public WebElement cartMenuButton;
    ////a/img/following::a/preceding::img/following::a[text()='View cart'][3]
    public void addRandomItemsToCart() throws InterruptedException {
        List<WebElement> cartItmes = driver.findElements(By.xpath("//a/img"));
        System.out.println("Total items in Shop page are: " + cartItmes.size());
        for (int i = 1; i <= cartItmes.size(); i++) {
            action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ellie-thumb-wrapper']//following::img["+i+"]")))).build().perform();
            action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img/following::a/preceding::img/following::a[text()='Add to cart']["+i+"]")))).click();
            if(i % 4 == 0) {
                break;
            }
        }
    }

    public void navigateToCartPage() {
        action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/img/following::a/preceding::img/following::a[text()='View cart'][3]")))).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cartMenuButton);
    }
}
