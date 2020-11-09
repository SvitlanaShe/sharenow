package com.sharenow.pageobject;

import com.sharenow.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {
    WebDriver driver;
    WaitHelper waitHelper;

    private static final String addressCountryIsoCodeXpath = "//*[@name='addressCountryIsoCode'][not(@is-required)]";
    By addressCountryIsoBy = By.xpath(addressCountryIsoCodeXpath);
    private static final String errorCss = "[class=error_hint]";
    By errorBy = By.cssSelector(errorCss);
    private String selectXpath = "//*[@name=\"%s\"][not(@is-required)]";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(addressCountryIsoBy, 10);
    }

    @FindBy(xpath = addressCountryIsoCodeXpath)
    WebElement addressCountryIso;

    @FindBy(id = "registration-save-button")
    WebElement registerButton;

    @FindBy(css = errorCss)
    List<WebElement> errorsList;

    @FindBy(xpath = "//input[@type='checkbox' ][@required]")
    private WebElement gdprCheckbox;

    @FindBy(xpath = "//*[@name=\"birthDate\"][not(@is-required)]")
    List<WebElement> birthDateList;

    public boolean verifyRegistrationPageIsOpened() {
        return addressCountryIso.isDisplayed();
    }

    public void clickRegisterNowButton() {
        registerButton.click();
    }

    public int getErrorsCount() {
        waitHelper.waitForElementPresent(errorBy);
        return errorsList.size();
    }

    public void selectFrom(String field, String data) {
        if (!field.equals("birthDate")) {
            WebElement el = getElement(field);
            new Select(el)
                    .selectByValue(data);
        } else {
            String[] birth = data.split("\\.");
            for (int i = 0; i < 3; i++) {
                new Select(birthDateList.get(i))
                        .selectByValue(birth[i]);
            }
        }
    }

    private WebElement getElement(String field) {
        return driver.findElement(By.xpath(String.format(selectXpath, field)));
    }

    public void typeIn(String field, String data) {
        getElement(field).
                sendKeys(data);
    }

    public void checkGdprCheckbox() {
        new Actions(driver)
                .moveToElement(gdprCheckbox).click().perform();
    }
}
