package automationexercise_StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import automationexercise_POM.AE_HomePage_POM;
import automationexercise_POM.AE_SignUpPage_POM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AE_NewUserSignUp_Steps {
	
	WebDriver driver=AE_Hooks.getDriver();

	AE_HomePage_POM hp;
	AE_SignUpPage_POM sp;
	
			
	@Given("User is on the home page")
	public void user_is_on_the_home_page() throws IOException {
		System.out.println("Inside User is on the home page");
		hp = new AE_HomePage_POM(driver);
		System.out.println("Page Title : "+ driver.getTitle());
	}

	@When("User clicks on the Signup and Login Link")
	public void user_clicks_on_the_signup_login_link() {
		System.out.println("Inside User clicks on the Signup and Login Link");
		hp = new AE_HomePage_POM(driver);
		hp.clickSignup();
	}

	@Then("User is taken to the New User Signup or login page")
	public void user_is_taken_to_the_new_user_signup_page() {
		System.out.println("Inside User is taken to the New User Signup or login page");
		sp = new AE_SignUpPage_POM(driver);
		if(sp.checkHeadingNewUserSignUp()) {
			System.out.println("User is taken to the New User SignUp or Login Page");
		}
		else
		{
			System.out.println("User is taken to wrong Page");
		}
	}


	@When("User enters name {string}")
	public void user_enters_name(String name) {

		sp.enterName(name);
	}

	@When("User enters email {string}")
	public void user_enter_email(String email) {

		sp.enterEmail(email);
	}

	@When("^user clicks on Signup button$")
	public void user_clicks_on_signup_button() {

		sp.clickSignUpButton();
	}

	@And("User enters the following account Details")
	public void User_enters_the_following_account_Details(DataTable accountTable) {

		Map<String,String> acctDetails=accountTable.asMap(String.class,String.class);
		sp.selectTitle(acctDetails.get("Title"));
		sp.enterPassword(acctDetails.get("Password"));
		sp.selectDOB(acctDetails.get("Day"), acctDetails.get("Month"), acctDetails.get("Year"));
	
	}

	@And("User enters the following Address Details")
	public void User_enters_the_following_Address_Details(DataTable addressTable) {
		
		List<List<String>> addressDetails=addressTable.asLists(String.class);
		
		List<String> row = addressDetails.get(0);
				
		sp.enterFirstName(row.get(0));
		sp.enterLastName(row.get(1));
		sp.enterAddress(row.get(2));
		sp.selectCountry(row.get(3));
		sp.enterState(row.get(4));
		sp.enterCity(row.get(5));
		sp.enterZipCode(row.get(6));
		sp.enterMobileNumber(row.get(7));
	}

	@Then("User clicks on createAccount button")
	public void user_clicks_on_create_account_button() {

		sp.clickCreateAccount();

	}

	@And("User account created successfully")
	public void User_account_created_successfully() throws IOException {

		try {
			if(sp.checkAccountCreation()) {
				System.out.println("Yay, New User Account Created Successfully");
				sp.clickContinue();
				sp.clickLogout();
			}
		}
		catch(Exception e) {
			System.out.println("Error Creating account"+e.getMessage());
		}
		
	}


}
