package com.sharenow.stepDefinition;

import com.sharenow.framework.Basic;
import com.sharenow.pageobject.PaymentPage;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

public class PaymentSteps extends Basic {
    Logger logger = setLogger(this.getClass());
    PaymentPage paymentPage = new PaymentPage(driver);

    @Then("Payment page is opened")
    public void paymentPageIsOpened() {
        paymentPage.verifyIsOpened();
        logger.info("Payment page should be shown!");
    }

}
