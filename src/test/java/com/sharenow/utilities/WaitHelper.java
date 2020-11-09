package com.sharenow.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    private WebDriver driver;
    public static final int WAIT_ELEMENT_TIME = 10;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By elBy, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(elBy));
        return driver.findElement(elBy);
    }

    public WebElement waitForElementPresent(By elBy) {
        return waitForElement(elBy, WAIT_ELEMENT_TIME);
    }

    public void waitUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_ELEMENT_TIME);
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void waitForElementNotPresent(By elBy, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
wait.until(ExpectedConditions.invisibilityOfElementLocated(elBy));
    }

    public WebElement waitUntilClickable(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_ELEMENT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(el));
        return el;
    }
}
