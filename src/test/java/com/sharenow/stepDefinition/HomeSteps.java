package com.sharenow.stepDefinition;

import com.sharenow.framework.Basic;
import com.sharenow.pageobject.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class HomeSteps extends Basic {

    Logger logger = setLogger(this.getClass());
    HomePage homePage;

    @Given("user is on ShareNow home page")
    public void user_is_on_home_page() {
        driver.get(homeUrl);
        homePage = new HomePage(driver);
        logger.info("Share Now home page is opened!");
    }

    @When("user clicks the button 'Choose a Country'")
    public void userClicksTheButtonChooseACountry() {
        homePage.clickChooseACountryButton();
    }

    @And("close driver")
    public void closeDriver() {
        if(driver!=null){
            try{
                driver.close();
                driver.quit();
                driver=null;
            }
            catch (Exception e){

            }
        }
    }
}
