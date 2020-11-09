package com.sharenow.pageobject;

import com.sharenow.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    WaitHelper waitHelper;
    private static final String chooseACountryId = "link-country-selector-page";
    private static final By chooseACountryBy = By.id(chooseACountryId);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(id = chooseACountryId)
    WebElement chooseACountryButton;

    public void clickChooseACountryButton() {
        waitHelper.waitForElementPresent(chooseACountryBy).click();
    }
}
