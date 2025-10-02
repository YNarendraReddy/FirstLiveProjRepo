package com.tutorialsninja.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;

import io.cucumber.datatable.DataTable;

public class RegisterPage {
	
	public RegisterPage() {
		
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	public static WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	public static WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	public static WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	public static WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	public static WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	public static WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	public static WebElement continueButton;

	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Register']")
	public static WebElement registerBreadCrumb;
	
	@FindBy(css="input[id='input-firstname']+div")
	public static WebElement firstNameWarning;
	
	@FindBy(css="input[id='input-lastname']+div")
	public static WebElement lastNameWarning;
	
	@FindBy(css="input[id='input-email']+div")
	public static WebElement emailWarning;
	
	@FindBy(css="input[id='input-telephone']+div")
	public static WebElement telephoneWarning;
	
	@FindBy(css="input[id='input-password']+div")
	public static WebElement passwordWarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	public static WebElement mainWarning;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	public static WebElement subscribeButton;
	
	public static void enterAllDetails(DataTable dataTable, String detailsType) {
		
		Map<String, String> data = dataTable.asMap(String.class, String.class);
    	Elements.typeText(RegisterPage.firstName, data.get("FirstName"));
    	Elements.typeText(RegisterPage.lastName, data.get("LastName"));
    	Elements.typeText(RegisterPage.telephone, data.get("Telephone"));
    	Elements.typeText(RegisterPage.password, data.get("Password"));
    	Elements.typeText(RegisterPage.confirmPassword, data.get("Password"));
    	
    	if(detailsType.equalsIgnoreCase("duplicate"))
    		Elements.typeText(RegisterPage.email, data.get("Email"));
    	else
    		Elements.typeText(RegisterPage.email, System.currentTimeMillis()+data.get("Email"));
	}
}
