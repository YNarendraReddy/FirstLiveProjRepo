package com.tutorialsninja.automation.framework;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tutorialsninja.automation.base.Base;

public class Elements {

    public static final Logger log = LogManager.getLogger(Elements.class);

    private static WebDriverWait getWait(int seconds) {
        return new WebDriverWait(Base.driver, Duration.ofSeconds(seconds));
    }

    // ------------------ Textbox Methods ------------------
    public static void typeText(WebElement element, String data) {
        element.sendKeys(data);
    }

    public static void typeTextIfVisible(WebElement element, String data) {
        if (isDisplayed(element)) {
            element.sendKeys(data);
        }
    }

    public static void clearTextBox(WebElement element) {
        element.clear();
    }

    public static void typeRandomNumber(WebElement element, int max) {
        Random random = new Random();
        int rn = random.nextInt(max);
        element.sendKeys(Integer.toString(rn));
    }

    public static String getTextBoxValue(WebElement element) {
        return element.getAttribute("value");
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static boolean verifyTextEquals(WebElement element, String expected) {
        return element.getText().equals(expected);
    }

    public static String getTitle() {
        return Base.driver.getTitle();
    }

    public static String getCurrentUrl() {
        return Base.driver.getCurrentUrl();
    }

    // ------------------ Checkbox / Radio ------------------
    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public static void selectCheckBox(WebElement element) {
        if (!isSelected(element))
            element.click();
    }

    public static void deselectCheckBox(WebElement element) {
        if (isSelected(element))
            element.click();
    }

    public static void selectRadioButton(WebElement element) {
        if (!isSelected(element))
            element.click();
    }

    public static void deselectRadioButton(WebElement element) {
        if (isSelected(element))
            element.click();
    }

    // ------------------ General Element States ------------------
    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // ------------------ Dropdown Methods ------------------
    public static void selectByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public static String getFirstSelectedOption(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    public static List<WebElement> getAllSelectedOptions(WebElement element) {
        return new Select(element).getAllSelectedOptions();
    }

    public static List<WebElement> getAllOptions(WebElement element) {
        return new Select(element).getOptions();
    }

    public static void deselectByText(WebElement element, String text) {
        new Select(element).deselectByVisibleText(text);
    }

    public static void deselectByIndex(WebElement element, int index) {
        new Select(element).deselectByIndex(index);
    }

    public static void deselectByValue(WebElement element, String value) {
        new Select(element).deselectByValue(value);
    }

    // ------------------ Click Methods ------------------
    public static void click(WebElement element) {
        waitUntilVisible(element, 10);
        element.click();
    }

    public static void clickIfVisible(WebElement element) {
        if (isDisplayed(element))
            element.click();
    }

    // ------------------ Alert Methods ------------------
    public static Alert getAlert() {
        return Base.driver.switchTo().alert();
    }

    public static void acceptAlert() {
        getAlert().accept();
    }

    public static void dismissAlert() {
        getAlert().dismiss();
    }

    public static String getAlertText() {
        return getAlert().getText();
    }

    public static boolean isAlertPresent() {
        try {
            Base.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void acceptAlertIfPresent() {
        if (isAlertPresent()) acceptAlert();
    }

    public static void dismissAlertIfPresent() {
        if (isAlertPresent()) dismissAlert();
    }

    public static void acceptPrompt(String text) {
        if (isAlertPresent()) {
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
        }
    }

    // ------------------ Scroll Methods ------------------
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Base.driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElementAndClick(WebElement element) {
        scrollToElement(element);
        element.click();
    }

    public static void scrollDownVertically() {
        ((JavascriptExecutor) Base.driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollUpVertically() {
        ((JavascriptExecutor) Base.driver)
                .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public static void scrollDownByPixel(int pixels) {
        ((JavascriptExecutor) Base.driver)
                .executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static void scrollUpByPixel(int pixels) {
        ((JavascriptExecutor) Base.driver)
                .executeScript("window.scrollBy(0,-" + pixels + ")");
    }

    // ------------------ Zoom Methods ------------------
    public static void zoomInByPercentage(int percentage) {
        ((JavascriptExecutor) Base.driver)
                .executeScript("document.body.style.zoom='" + percentage + "%'");
    }

    public static void zoomTo100() {
        ((JavascriptExecutor) Base.driver)
                .executeScript("document.body.style.zoom='100%'");
    }

    // ------------------ Wait ------------------
    public static void waitUntilVisible(WebElement element, int timeoutSeconds) {
        getWait(timeoutSeconds).until(ExpectedConditions.visibilityOf(element));
    }

}
