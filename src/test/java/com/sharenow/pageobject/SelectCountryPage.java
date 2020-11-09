package com.sharenow.pageobject;

import com.sharenow.framework.Basic;
import com.sharenow.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCountryPage {

    WebDriver driver;
    WaitHelper waitHelper;
    private static final String berlinId = "city-page-berlin";
    private static final String countryCityId = "city-picker";
    private By countryCityBy = By.id(countryCityId);

    public SelectCountryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitUrlContains(Basic.homeUrl + "/us/en/country-list/");
    }

    @FindBy(id = berlinId)
    WebElement berlin;

    public boolean containsCountryCityList() {
        return waitHelper.waitForElementPresent(countryCityBy).isDisplayed();
    }

    public void clickOn(String city) {
        String cityId = String.format("city-page-%s",city.toLowerCase());
        getCityElement(cityId).click();
        waitHelper.waitUrlContains(String.format("%s%s%s", Basic.homeUrl, "/de/en/", city.toLowerCase()));
    }

    private WebElement getCityElement(String city){
        return driver.findElement(By.id(city));
    }
}
