package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Browser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import java.util.Map;

public class Register {

    @Given("I launch the application")
    public void i_launch_the_application() {
        Base.driver.get(Base.reader.getUrl());
    }

    @And("I navigate to Account Registration page")
    public void i_navigate_to_Account_Registration_page() {
//        // Example: click "My Account" → "Register"
//        Base.driver.findElement(By.linkText("My Account")).click();
//        Base.driver.findElement(By.linkText("Register")).click();
    }

    @When("I provide all the below valid details")
    public void i_provide_all_the_below_valid_details(DataTable dataTable) {
//        Map<String, String> data = dataTable.asMap(String.class, String.class);
//
//        Base.driver.findElement(By.id("input-firstname")).sendKeys(data.get("FirstName"));
//        Base.driver.findElement(By.id("input-lastname")).sendKeys(data.get("LastName"));
//        Base.driver.findElement(By.id("input-email")).sendKeys(data.get("Email"));
//        Base.driver.findElement(By.id("input-telephone")).sendKeys(data.get("Telephone"));
//        Base.driver.findElement(By.id("input-password")).sendKeys(data.get("Password"));
    }

    @And("I select the Privacy Policy")
    public void i_select_the_Privacy_Policy() {
//        Base.driver.findElement(By.name("agree")).click();
    }

    @And("I click on Continue button")
    public void i_click_on_Continue_button() {
//        Base.driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();
    }

    @Then("I should see that the User Account has successfully created")
    public void i_should_see_that_the_User_Account_has_successfully_created() {
//        boolean isCreated = Base.driver.getPageSource().contains("Your Account Has Been Created!");
//        if (!isCreated) {
//            throw new AssertionError("Account creation failed!");
//        }
    }
}
