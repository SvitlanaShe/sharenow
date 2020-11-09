package com.sharenow.stepDefinition;

import com.sharenow.framework.Basic;
import com.sharenow.pageobject.SelectCountryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SelectCountryCitySteps extends Basic {

    SelectCountryPage selectCountryPage = new SelectCountryPage(driver);

    @Then("user sees country list")
    public void userSeesCountryList() {
        Assert.assertTrue(selectCountryPage.containsCountryCityList());
    }

    @When("user selects a city {string}")
    public void userSelectsACity(String city) {
        selectCountryPage.clickOn(city);
    }
}
