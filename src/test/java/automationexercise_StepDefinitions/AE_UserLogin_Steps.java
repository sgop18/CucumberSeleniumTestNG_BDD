package automationexercise_StepDefinitions;

import org.openqa.selenium.WebDriver;

import automationexercise_POM.AE_LoginPage_POM;
import automationexercise_POM.AE_SignUpPage_POM;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class AE_UserLogin_Steps {

	WebDriver driver = AE_Hooks.getDriver();
	AE_LoginPage_POM lp;


	@When("user enter email {string} and {string}")
	public void user_enter_email_and(String email, String pwd) {
		lp=new AE_LoginPage_POM(driver);
		lp.enterLoginemail(email);
		lp.enterLoginpassword(pwd);
	}

	@And("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		if(driver==null)
		{
			lp=new AE_LoginPage_POM(driver);
		}
		lp.clickLoginbutton();
	}

	@Then("user is successfully logged in")
	public void user_is_successfully_logged_in() {
		
			if(lp.verifyLogoutlinkPresence()) {
				System.out.println("User successfully Logged in");
			}
		}

	@And("user verifies the {string} message")
	public void user_verifies_the_message(String msg) {
		
			String actualMsg = lp.verifyLoginsuccessmsg();	
			
			if (actualMsg.contains(msg)) {
		        System.out.println("Message Verified: " + actualMsg);
		    } else {
		        System.out.println("Expected message to contain: " + msg);
		        System.out.println("Actual message: " + actualMsg);
		    }
			
	}
	
}

