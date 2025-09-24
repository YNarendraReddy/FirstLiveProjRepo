package com.tutorialsninja.automation.base;

import org.openqa.selenium.WebDriver;
import com.tutorialsninja.automation.config.ConfigurationReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Base {
    
    public static final Logger log = LogManager.getLogger(Base.class);
    
    public static WebDriver driver;
    public static ConfigurationReader reader;
}
