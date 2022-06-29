package com.ecommerce.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {

        //Constructor
        public CartPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//td[@class='product-thumbnail']")
    public List<WebElement> totalItemsInCart;

    @FindBy(xpath = "//td[@class='product-subtotal']/span[@class='woocommerce-Price-amount amount'][text()]")
    public List<WebElement> priceOfItemsInCart;

    @FindBy(xpath = "//a[@class='remove']")
    public WebElement removeItemInCart;

    public void findTotalElementsinCart() throws InterruptedException {
      wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//td[@class='product-thumbnail']"))));
      Integer itemsInCart = totalItemsInCart.size();
      if (itemsInCart==4) {
          System.out.println("Total size of the cart is :" + itemsInCart);
      } else {
          System.out.println("Total size of the cart is 'Not Four', and it is " + itemsInCart);
      }
    }

    public void findLowestItemPriceInCart() {
        List<WebElement> lists = driver.findElements(By.xpath("//td[@class='product-subtotal']/span[@class='woocommerce-Price-amount amount'][text()]"));
        for (int i = 0; i < lists.size(); i++) {
            List<String> itemPriceListinCart = Collections.singletonList((lists.get(i).getText()));
            System.out.println(itemPriceListinCart);
        }
    }

    public void removeLowestPricedItemFromCart() throws InterruptedException {
        action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='remove']")))).build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", removeItemInCart);
        Thread.sleep(5000);
    }

}
