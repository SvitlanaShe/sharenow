package com.sharenow.pageobject;

import com.sharenow.utilities.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage {
    WebDriver driver;
    WaitHelper waitHelper;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitUrlContains("registration/payment");
    }

    private static final String paymentFormCss = "div.registration-payment-form";
    By paymentFormBy = By.cssSelector(paymentFormCss);

    @FindBy(css = paymentFormCss)
    WebElement paymentForm;

    public void verifyIsOpened() {
        waitHelper.waitForElement(paymentFormBy, 3);
    }
}
