package com.katalonDemo.test;

import com.katalonDemo.pages.HomePage;

public class HomePageTest {

    HomePage homePage = new HomePage();

    public void addRandomFourItemsToCart() {
        homePage.addFourRandomItemsToCart();
    }
}
