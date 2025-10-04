package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

public class LoginPage {
	
	public LoginPage() {
		
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	public static WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	public static WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	public static WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	public static WebElement mainWarning;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	public static WebElement forgotPassword;
	
	public static void doLogin(String email, String password) {
		
		Elements.typeText(LoginPage.emailField, email);
		Elements.typeText(LoginPage.passwordField, password);
		Elements.click(LoginPage.loginButton);
	}

}
