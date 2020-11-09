package com.sharenow.framework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    String browser;
    private Logger logger;

    public BrowserDriverFactory(String browser, Logger logger) {
        this.browser = browser;
        this.logger = logger;
    }

    public WebDriver createDriver() {
        logger.info("Create driver: " + browser);
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }

    }

}
