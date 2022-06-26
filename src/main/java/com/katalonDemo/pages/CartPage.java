package com.katalonDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import static com.katalonDemo.utils.DriverUtils.getDriver;
import static com.katalonDemo.utils.WebElementUtils.waitForVisible;

public class CartPage {

    @FindBy(xpath = "//div/ul/li[1]")
    private WebElement cart;

    @FindBy(className = "page-title")
    private WebElement cartTitle;

    @FindBy(xpath = "//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']")
    private List<WebElement> cartTable;

    int lowestPriceElement;

    public CartPage() {
        PageFactory.initElements(getDriver(), this);

    }


    public void viewCart() {
        waitForVisible(cart);
        cart.click();
        waitForVisible(cartTitle);
    }

    public int verifyItemsInCart() {
        return cartTable.size();
    }

    public void searchForLowestPriceItem() {
        Map<Integer, Double> productPrice = new HashMap<Integer, Double>();
        List<WebElement> cartTableElements = getDriver().findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']"));
        for (int product = 1; product <= cartTableElements.size(); product++) {
            String priceWithoutDollar = getDriver().findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr[@class='woocommerce-cart-form__cart-item cart_item'][" + product + "]/td[4]/span")).getText().replace("$", "");
            Double parsePrice = Double.parseDouble(priceWithoutDollar);
            productPrice.put(product, parsePrice);
        }
        Double min = Collections.min(productPrice.values());
        for (Map.Entry<Integer, Double> entry : productPrice.entrySet()) {
            if (entry.getValue().equals(min)) {
                lowestPriceElement = entry.getKey();
            }
        }

    }

    public void removeLowestPriceItem() {
        WebElement removeElement = getDriver().findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr[@class='woocommerce-cart-form__cart-item cart_item'][" + lowestPriceElement + "]/td[1]/a"));
        removeElement.click();
    }
}
