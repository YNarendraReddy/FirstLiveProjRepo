package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeaderSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	HeaderSection headerSection = new HeaderSection();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	
	@And("I naviage to Account Login page")
	public void i_naviage_to_account_login_page() {
	   Elements.click(HeaderSection.myAccountLink);
	   Elements.click(HeaderSection.login);
	}
	
	@When("I login to the application using Username {string} and Password {string}")
	public void i_login_to_the_application_using_username_and_password(String email, String password) {
	   LoginPage.doLogin(email, password);
	}
	
	@Then("I should see that the User is able to successfully login")
	public void i_should_see_that_the_user_is_able_to_successfully_login() {
	    
		Assert.assertTrue(Elements.isDisplayed(MyAccountPage.registerAffliateAccount));
	}
	
	@Then("I should see an error message informing the User about invalid credentials")
	public void i_should_see_an_error_message_informing_the_user_about_invalid_credentials() {
	    
		Assert.assertTrue(Elements.verifyTextEquals(LoginPage.mainWarning, "Warning: No match for E-Mail Address and/or Password."));
	}
	
	@When("I reset the forgotten password for email {string}")
	public void i_reset_the_forgotten_password_for_email(String email) {
	    
		Elements.click(LoginPage.forgotPassword);
		Elements.typeText(ForgotPasswordPage.emailFeild, email);
		Elements.click(ForgotPasswordPage.continueButton);
	}

	@Then("I should see a message informing that the password reset details have been sent to the email address")
	public void i_should_see_a_message_informing_that_the_password_reset_details_have_been_sent_to_the_email_address() {
	    
		Assert.assertTrue(Elements.verifyTextEquals(LoginPage.mainWarning, "An email with a confirmation link has been sent your email address."));
	}

}
