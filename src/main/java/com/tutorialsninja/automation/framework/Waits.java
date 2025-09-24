package com.tutorialsninja.automation.framework;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tutorialsninja.automation.base.Base;

public class Waits {

    public static final Logger log = LogManager.getLogger(Waits.class);

    private static final int defaultTimeout = 30;

    // ------------------ Implicit Wait ------------------
    public static void setImplicitWait(int seconds) {
        Base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // ------------------ Explicit Wait ------------------
    public static void waitUntilElementVisible(int seconds, WebElement element) {
        new WebDriverWait(Base.driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementClickable(int seconds, WebElement element) {
        new WebDriverWait(Base.driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // ------------------ JavaScript Execution ------------------
    public static synchronized Object execJavascript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) Base.driver;
        return js.executeScript(script, args);
    }

    public static synchronized Object tryJavascript(String script, Object... args) {
        try {
            return execJavascript(script, args);
        } catch (Exception e) {
            log.warn("JavaScript execution failed: {}", e.getMessage());
            return "";
        }
    }

    // ------------------ Page / JS Wait Checks ------------------
    public static boolean isPageLoaded() {
        String state = (String) tryJavascript("return document.readyState;");
        return state.matches("complete|loaded|interactive");
    }

    public static boolean isJQueryDone() {
        Object jsResponse = tryJavascript("return jQuery.active;");
        if (jsResponse instanceof Long) {
            return ((Long) jsResponse) == 0;
        } else if (jsResponse instanceof String) {
            return ((String) jsResponse).isEmpty();
        } else {
            return true;
        }
    }

    public static boolean isAngularDone() {
        Object jsResponse = tryJavascript(
                "return window.getAllAngularTestabilities().filter(x => !x.isStable()).length;");
        if (jsResponse instanceof Long) {
            return ((Long) jsResponse) == 0;
        } else if (jsResponse instanceof String) {
            return ((String) jsResponse).isEmpty();
        } else {
            return true;
        }
    }

    // ------------------ Custom Condition Wait ------------------
    public static void waitUntil(BooleanSupplier condition, int seconds) {
        new WebDriverWait(Base.driver, Duration.ofSeconds(seconds))
                .until((WebDriver driver) -> condition.getAsBoolean());
    }

    public static void waitUntil(BooleanSupplier condition) {
        waitUntil(condition, defaultTimeout);
    }
}
