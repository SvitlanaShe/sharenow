package com.sharenow.pageobject;

import com.sharenow.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceptBannerPage {

    WebDriver driver;
    WaitHelper waitHelper;
    private static final String acceptBannerCss = "button#uc-btn-accept-banner.uc-btn-accept";
    private static final By acceptBannerBy = By.cssSelector(acceptBannerCss);

    public AcceptBannerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElementPresent(acceptBannerBy);
    }

    @FindBy(css = acceptBannerCss)
    WebElement acceptBannerButton;

    public void acceptBanner() {
        waitHelper.waitUntilClickable(acceptBannerButton).click();
        waitHelper.waitForElementNotPresent(acceptBannerBy,3);
    }
}
