package com.tutorialsninja.automation.framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tutorialsninja.automation.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Browser {

    public static final Logger log = LogManager.getLogger(Browser.class);

    public static WebDriver startBrowser() {
        String browser = Base.reader.getBrowser().toLowerCase();
        log.info("Selected Browser is: {}", browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Base.driver = new ChromeDriver();
                log.info("Chrome Browser is Started: {}", Base.driver.hashCode());
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                Base.driver = new ChromeDriver(options);
                log.info("Chrome Headless Browser is Started: {}", Base.driver.hashCode());
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                Base.driver = new InternetExplorerDriver();
                log.info("Internet Explorer Browser is Started: {}", Base.driver.hashCode());
                break;

            default: // Firefox
                WebDriverManager.firefoxdriver().setup();
                Base.driver = new FirefoxDriver();
                log.info("Firefox Browser is Started: {}", Base.driver.hashCode());
                break;
        }

        return Base.driver;
    }

    public static void maximize() {
        Base.driver.manage().window().maximize();
    }

    public static byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            log.error("Exception occurred while taking screenshot", e);
            return null;
        }
    }
}
