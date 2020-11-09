package com.sharenow.stepDefinition;

import com.sharenow.framework.Basic;
import com.sharenow.pageobject.HomeCountryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class HomeCountrySteps extends Basic {

    HomeCountryPage homeCountryPage = new HomeCountryPage(driver);

    @When("user clicks 'Join for free' button")
    public void userClicksJoinForFreeButton() {
homeCountryPage.clickJoinForFreeHeaderButton();
    }

    /*
    language choice: english, german
     */
    @And("user selects language {string}")
    public void userSelectsLanguage(String language) {
        homeCountryPage.selectLanguage(language);
    }

}
