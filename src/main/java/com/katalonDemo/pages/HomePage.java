package com.katalonDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.katalonDemo.utils.CommonUtils.randomNumberGenerator;
import static com.katalonDemo.utils.DriverUtils.getDriver;
import static com.katalonDemo.utils.WebElementUtils.waitForVisible;

public class HomePage {


    ProductPage productPage;
    Actions actions;
    @FindBy(xpath = "//div/p[@class='site-title']")
    private WebElement header;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
        productPage = new ProductPage();
        actions = new Actions(getDriver());
    }

    public void addFourRandomItemsToCart() {
        waitForVisible(header);
        String addToCartButtonText;

        List<Integer> randomNumberList = randomNumberGenerator();

        int randomNumber;

        for (int items = 0; items <= 3; items++) {

            randomNumber = randomNumberList.get(items);

            if (randomNumber != 5 && randomNumber != 0) {

                waitForVisible(getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + randomNumber + "]")));
                actions.moveToElement(getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + randomNumber + "]"))).perform();
                addToCartButtonText = getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + randomNumber + "]/div/a[2]")).getText();
                getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + randomNumber + "]")).click();

            } else {
                waitForVisible(getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + 12 + "]")));
                actions.moveToElement(getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + 12 + "]/div/a[2]"))).perform();
                addToCartButtonText = getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + 12 + "]/div/a[2]")).getText();
                getDriver().findElement(By.xpath("//div[@id='primary']//ul/li[" + 12 + "]")).click();
            }

            switch (addToCartButtonText) {
                case "ADD TO CART":
                    System.out.println("Case ATC:" + addToCartButtonText);
                    productPage.addToCart();
                    break;

                case "SELECT OPTIONS":
                    System.out.println("Case SO:" + addToCartButtonText);
                    productPage.selectOptionsAddToCart();
                    break;
            }
        }
    }
}
