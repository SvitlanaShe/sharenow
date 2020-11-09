package com.sharenow.pageobject;

import com.sharenow.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeCountryPage {
    WebDriver driver;
    WaitHelper waitHelper;
    private static final String joinForFreeButtonXpath = "//div[@class='primary-navbar__content']//a[@id='button-register-now']";
    private static final By joinForFreeButtonBy = By.xpath(joinForFreeButtonXpath);

    public HomeCountryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElementPresent(joinForFreeButtonBy);
    }

    @FindBy(className = "language-selector")
    private WebElement languageSelector;

    @FindBy(xpath = joinForFreeButtonXpath)
    WebElement joinForFreeButton;

    public void clickJoinForFreeHeaderButton() {
        joinForFreeButton.click();
    }

    public void selectLanguage(String language) {
        languageSelector.click();
        if ("english".equals(language.toLowerCase()))
            selectEnglishLanguageFromDropdown();
        else
            selectGermanLanguageFromDropdown();
    }

    private void selectEnglishLanguageFromDropdown() {
        languageSelector.findElements(By.tagName("li")).get(1).click();
    }

    private void selectGermanLanguageFromDropdown() {
        languageSelector.findElements(By.tagName("li")).get(0).click();
    }
}
