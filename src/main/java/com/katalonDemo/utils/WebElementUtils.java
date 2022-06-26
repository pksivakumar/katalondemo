package com.katalonDemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.katalonDemo.utils.DriverUtils.getDriver;


public class WebElementUtils {

    static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));

    public static void waitForVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.getStackTrace().toString();
        }
    }

}
