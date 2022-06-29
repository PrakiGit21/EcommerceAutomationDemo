package com.ecommerce.automation.StepDefinitions;

import com.ecommerce.automation.Pages.CartPage;
import com.ecommerce.automation.Utilities.BaseUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ecommerce.automation.Pages.HomePage;

public class Add_Items_To_Cart_StepDefinitions extends BaseUtilities {

    HomePage homepage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);
    @Given("I add four random items to cart")
    public void add_Random_Items_To_Cart() throws InterruptedException {
        homepage.navigateToApplicationUrl();
        homepage.addRandomItemsToCart();
    }

    @When("I view my cart")
    public void iViewMyCart() throws InterruptedException {
        homepage.navigateToCartPage();
    }

    @Then("I find total four items listed in my cart")
    public void i_Find_Total_Four_Items_Listed_In_My_Cart() throws InterruptedException {
        cartPage.findTotalElementsinCart();
    }


    @When("I search for lowest price item")
    public void iSearchForLowestPriceItem() {
        cartPage.findLowestItemPriceInCart();
    }

    @And("I am able to remove the lowest price item from my cart")
    public void iAmAbleToRemoveTheLowestPriceItemFromMyCart() throws InterruptedException {
        cartPage.removeLowestPricedItemFromCart();
    }

    @Then("I am able to verify three items in my cart")
    public void iAmAbleToVerifyThreeItemsInMyCart() throws InterruptedException {
        cartPage.findTotalElementsinCart();
    }
}
