package com.sharenow.stepDefinition;

import com.sharenow.framework.Basic;
import com.sharenow.pageobject.RegistrationPage;
import com.sharenow.utilities.EmailPhoneGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class RegistrationSteps extends Basic {

    Logger logger = setLogger(this.getClass());
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Then("registration page is opened")
    public void registrationPageIsOpened() {
        Assert.assertTrue(registrationPage.verifyRegistrationPageIsOpened());
    }

    @And("user clicks on \"Register Now\" button")
    public void userClicksOnRegisterNowButton() {
        registrationPage.clickRegisterNowButton();
    }

    @Then("{int} error\\(s) are shown for mandatory fields")
    public void errorsAreShownForMandatoryFields(int errorsCount) {
        Assert.assertEquals(errorsCount, registrationPage.getErrorsCount());
    }

    @When("user selects {string} {string} on Registration page")
    public void userSelectsOnRegistrationPage(String field, String data) {
        registrationPage.selectFrom(field, data);
    }

    @And("user types {string} {string} on Registration page")
    public void userTypesOnRegistrationPage(String field, String data) {
        if (field.equals("email")) {
            data = EmailPhoneGenerator.generateEmail(data);
        } else if (field.equals("mobilePhone")) {
            data = EmailPhoneGenerator.generateMobilePhone(data);
            logger.info("mobile phone "+ data);

        }
            registrationPage.typeIn(field, data);
    }

    @When("user checks GDPR checkbox")
    public void userChecksGDPRCheckbox() {
        registrationPage.checkGdprCheckbox();
    }
}
