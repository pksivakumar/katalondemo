package com.katalonDemo.stepDefinitions;

import com.katalonDemo.test.CartPageTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartPageStep {

    CartPageTest cartPageTest = new CartPageTest();

    @When("^I view my cart$")
    public void viewCart(){
        cartPageTest.viewCart();
    }

    @Then("^I find total four items listed in my cart$")
    public void verifyFourItemsInCart(){
        cartPageTest.verifyCartCount();
    }

    @When("^I search for lowest price item$")
    public void searchForLowestPrice(){
        cartPageTest.searchForLowestPriceItem();
    }

    @And("^I am able to remove the lowest price item from my cart$")
    public void removeLowestPriceItem(){
        cartPageTest.removeLowestPriceItem();
    }

    @Then("^I am able to verify three items in my cart$")
    public void verifyThreeItemsInCart(){
        cartPageTest.verifyThreeItemsInCart();
    }


}
