package com.katalonDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.katalonDemo.utils.DriverUtils.getDriver;
import static com.katalonDemo.utils.WebElementUtils.waitForVisible;



public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div/p[@class='site-title']")
    private WebElement header;

    @FindBy(id = "pa_color")
    private WebElement selectColour;

    @FindBy(xpath = "//button[contains(@class, 'single_add_to_cart_button')]")
    private WebElement selectAddToCart;

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

    Actions actions;

    public ProductPage() {

        PageFactory.initElements(getDriver(), this);
        actions = new Actions(getDriver());
    }


    public void addToCart() {

        actions.moveToElement(addToCartButton).perform();
        waitForVisible(addToCartButton);
        addToCartButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-message")));
        header.click();
        waitForVisible(header);
    }

    public void selectOptionsAddToCart() {

        actions.moveToElement(selectColour).perform();
        waitForVisible(selectColour);
        Select select = new Select(selectColour);
        select.selectByIndex(1);
        selectAddToCart.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-message")));
        header.click();
        waitForVisible(header);

    }
}
