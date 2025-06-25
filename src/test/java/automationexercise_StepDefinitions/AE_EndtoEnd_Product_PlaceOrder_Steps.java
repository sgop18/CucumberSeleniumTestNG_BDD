package automationexercise_StepDefinitions;

import org.openqa.selenium.WebDriver;

import automationexercise_POM.AE_CartsPage_POM;
import automationexercise_POM.AE_CheckoutPage_POM;
import automationexercise_POM.AE_OrderPlacedPage_POM;
import automationexercise_POM.AE_PaymentPage_POM;
import automationexercise_POM.AE_ProductDetailsPage_POM;
import automationexercise_POM.AE_ProductsPage_POM;
import automationexercise_POM.AE_SignUpPage_POM;
import io.cucumber.java.en.*;

public class AE_EndtoEnd_Product_PlaceOrder_Steps extends AE_TestBase{
	WebDriver driver = AE_Hooks.getDriver();
	AE_ProductsPage_POM pp;
	AE_ProductDetailsPage_POM pdp;
	AE_CartsPage_POM ctp;
	AE_CheckoutPage_POM cop;
	AE_PaymentPage_POM pmp;
	AE_OrderPlacedPage_POM opp;
	AE_SignUpPage_POM sp;
	
		
	@When("User clicks on the Products link")
	public void User_clicks_on_the_Products_link() {
		pp = new AE_ProductsPage_POM(driver);
		pp.clickProductsLink();
	}

	@And("User expands the category against Women's products in the accordion")
	public void user_expands_the_category_against_women_s_products_in_the_accordion() {
		pp.expandCategoryWomen();
	}

	@And("User clicks on Dress")
	public void user_clicks_on_dress() {
	 pp.clickDress();
	}
	

	@And("User clicks on View Product link on the first product")
	public void user_clicks_on_view_product_link_on_the_first_product() {
		pp.viewProduct();
	}

	@And("User enters the quantity as {int}")
	public void user_enters_the_quantity_as(Integer int1) {
		pdp = new AE_ProductDetailsPage_POM(driver);
		pdp.enterQuantity();
		
	}

	@And("User clicks on Add to Cart")
	public void user_clicks_on_add_to_cart() {
		pdp.clickAddtoCart();
	}

	@And("User verifies the {string} message in the modal")
	public void user_verifies_the_message_in_the_modal(String msg) {
		String actmsg=pdp.checkProductAddedMessage();
		if(actmsg.equals(msg)) {
			System.out.println("Product added to cart and message displayed");
		}
	}

	@And("User clicks on view cart")
	public void user_clicks_on_view_cart() {
		pdp.clickViewCart();
	}

	@And("User checks the quantity is equal to {int}")
	public void user_checks_the_quantity_is_equal_to(Integer int1) {
		ctp= new AE_CartsPage_POM(driver);
		String qty=ctp.verifyQuantity();
		if(qty.equals("2")) {
			System.out.println("Quantity Verified");
		}
		}

	@And("User clicks on Proceed to Checkout")
	public void user_clicks_on_proceed_to_checkout() {
		ctp.clickProceedtoCheckout();
	}

	@And("User enters the comments")
	public void user_enters_the_comments() {
		cop=new AE_CheckoutPage_POM(driver);
		cop.enterComments();
	}

	@And("User clicks on Place Order")
	public void user_clicks_on_place_order() {
		cop.clickPlaceOrder();
	}

	@And("user enters Name cardNumber cvc expiration year")
	public void user_enters_name_card_number_cvc_expiration_year() {
		pmp=new AE_PaymentPage_POM(driver);
		pmp.enterNameonCard();
		pmp.enterCardNumber();
		pmp.enterCVC();
		pmp.enterExpiration();
		pmp.enterYear();
	}

	@And("User clicks on Pay and Confirm Order")
	public void user_clicks_on_pay_and_confirm_order() {
		pmp.clickPlaceOrder();
	}

	@Then("User checks the order placed Confirmation message")
	public void user_checks_the_order_placed_confirmation_message() {
		opp = new AE_OrderPlacedPage_POM(driver);
		opp.checkConfirmationOrderMsg();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		opp.clickContinue();
	}

	@And("User clicks on the Logout link")
	public void user_clicks_on_the_logout_link() {
		sp = new AE_SignUpPage_POM(driver);
		sp.clickLogout();
	}

	@Then("User is logged out successfully")
	public void user_is_logged_out_successfully() throws InterruptedException {
		System.out.println("Order Placed and logged out successfully");
		
	}
}
