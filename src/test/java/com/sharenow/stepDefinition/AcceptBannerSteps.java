package com.sharenow.stepDefinition;

import com.sharenow.framework.Basic;
import com.sharenow.pageobject.AcceptBannerPage;
import io.cucumber.java.en.When;

public class AcceptBannerSteps extends Basic {
    AcceptBannerPage acceptBannerPage;

    @When("accept banner")
    public void acceptBanner() {
        acceptBannerPage = new AcceptBannerPage(driver);
        acceptBannerPage.acceptBanner();
    }
}
