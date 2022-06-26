package com.katalonDemo.test;

import com.katalonDemo.pages.CartPage;
import org.junit.Assert;

public class CartPageTest {

    CartPage cartPage = new CartPage();

    public void viewCart() {
        cartPage.viewCart();
    }

    public void verifyCartCount() {
        cartPage.viewCart();
        Assert.assertEquals(4, cartPage.verifyItemsInCart());
    }

    public void searchForLowestPriceItem() {
        cartPage.searchForLowestPriceItem();
    }

    public void removeLowestPriceItem() {
        cartPage.removeLowestPriceItem();
    }

    public void verifyThreeItemsInCart() {
        cartPage.viewCart();
        Assert.assertEquals(3, cartPage.verifyItemsInCart());
    }
}
