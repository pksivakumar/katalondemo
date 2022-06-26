package com.katalonDemo.stepDefinitions;

import com.katalonDemo.test.HomePageTest;
import cucumber.api.java.en.Given;

public class ProductsPageStep {

    HomePageTest productsPageTest = new HomePageTest();

    @Given("^I add four random items to my cart$")
    public void addFourItemsToCart() throws InterruptedException {

        productsPageTest.addRandomFourItemsToCart();

    }

}
