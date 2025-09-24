package com.tutorialsninja.automation.stepdef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.config.PropertyFileReader;
import com.tutorialsninja.automation.framework.Browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    
    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        log.info("Scenario Started: {}", scenario.getName());
        Base.reader = new PropertyFileReader();
        Browser.startBrowser();
        Browser.maximize();
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = Browser.takeScreenshot();
            scenario.attach(screenshot, "image/png", "Screenshot on Failure");
        }
        log.info("Scenario Completed: {}", scenario.getName());
        log.info("Scenario Status is: {}", scenario.getStatus());
        Base.driver.quit();
    }
}
