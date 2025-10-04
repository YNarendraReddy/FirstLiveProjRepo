package com.tutorialsninja.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;

public class ForgotPasswordPage {

	public ForgotPasswordPage() {
		
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	public static WebElement emailFeild;
	
	@FindBy(xpath="//input[@value='Continue']")
	public static WebElement continueButton;
}
