package automationexercise_StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import automationexercise_POM.AE_CartsPage_POM;
import automationexercise_POM.AE_HomePage_POM;
import automationexercise_POM.AE_LoginPage_POM;
import automationexercise_POM.AE_ProductsPage_POM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AE_Testcase_CartFunctions_TestNG_Steps {
	
	WebDriver driver=AE_Hooks.getDriver();
	
	AE_LoginPage_POM lp;
	AE_ProductsPage_POM pp;
	AE_HomePage_POM hp;
	AE_CartsPage_POM cp;
	
	@When("user enters email and password")
	public void user_enters_email_and_password(DataTable emailpwdTable) {
		Map<String,String> loginDetails = emailpwdTable.asMap(String.class,String.class);
		hp=new AE_HomePage_POM(driver);
		lp=new AE_LoginPage_POM(driver);
		lp.enterLoginemail(loginDetails.get("email"));
		lp.enterLoginpassword(loginDetails.get("password"));
		
	}
	
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    lp.clickLoginbutton();
	}
	
		
	@When("User searches for a Dress in the search box")
	public void user_searches_for_a_dress_in_the_search_box() {
		pp=new AE_ProductsPage_POM(driver);
		pp.searchProduct();
	}

	@When("User clicks on the search icon")
	public void user_clicks_on_the_search_icon() {
	    pp.clickSearchIcon();
	}

	
	@When("Verify if all the products displayed are dresses")
	public void verify_if_all_the_products_displayed_are_dresses() {
		
		SoftAssert softAssert = new SoftAssert();
		
		List<WebElement> productNames = pp.productNames();
		 for (WebElement eachProductName : productNames) {
		        String productName = eachProductName.getText();
		        boolean containsDress = productName.toLowerCase().contains("dress");
		 System.out.println(containsDress?"Product contains 'dress': " + productName:"Wrong Product"+productName);
		 
		 softAssert.assertTrue(containsDress, "Wrong product: " + productName);
		 }
		 softAssert.assertAll();
	}
	

	@When("User clicks on Cart")
	public void user_clicks_on_cart() {
		hp = new AE_HomePage_POM(driver);
		hp.clickCart();
	    
	}

	@When("User clicks on the X button to delete the product from the cart")
	public void user_clicks_on_the_x_button_to_delete_the_product_from_the_cart() {
	    cp= new AE_CartsPage_POM(driver);
	    cp.deleteProduct();
	    
	}

	@Then("User verifies if {string} message is displayed")
	public void user_verifies_if_message_is_displayed(String expectedMsg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cp.msgCartEmptyisDisplayed()));
	   String actualMsg=cp.msgCartEmpty();
		Assert.assertEquals(actualMsg, expectedMsg);
	    		    }
	   }
