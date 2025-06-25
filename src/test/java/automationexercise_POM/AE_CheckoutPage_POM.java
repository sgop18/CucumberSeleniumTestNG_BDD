package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_CheckoutPage_POM extends AE_commonConstructor_POM{
	
	public AE_CheckoutPage_POM(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//textarea[@name='message']") WebElement txt_Comments;
	@FindBy(xpath="//a[normalize-space()='Place Order']") WebElement lnk_PlaceOrder;
	
	
	public void enterComments() {
		txt_Comments.sendKeys("This is a test Order");
	}
	
	public void clickPlaceOrder() {
		lnk_PlaceOrder.click();
	}
}
