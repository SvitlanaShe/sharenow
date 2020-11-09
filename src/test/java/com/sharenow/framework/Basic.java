package com.sharenow.framework;

import com.sharenow.framework.drivers.BrowserDriverFactory;
import com.sharenow.utilities.WaitHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Basic {

    protected static WebDriver driver;
    protected static Logger logger;
    protected static final Properties prop = loadProperties("configuration.properties");
    public static final String homeUrl = prop.getProperty("home_url");
    protected WaitHelper waitHelper;

    protected Logger setLogger(Class clazz) {
        logger = LogManager.getLogger(clazz);
        PropertyConfigurator.configure("log4j.properties");
        return logger;
    }

    public Basic() {
        setLogger(Basic.class);
        waitHelper = new WaitHelper(driver);
        if (driver == null) {
            BrowserDriverFactory factory = new BrowserDriverFactory(prop.getProperty("browser"), logger);
            driver = factory.createDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
    }

    private static Properties loadProperties(String propertyFile) {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFile));
        } catch (IOException e) {
            logger.error("Error loading the " + propertyFile + " file", e);
        }
        return properties;
    }

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            try {
                driver.close();
                driver.quit();
            } catch (Exception e) {
            }
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

}
