package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_CartsPage_POM extends AE_commonConstructor_POM{
	
	public AE_CartsPage_POM(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[normalize-space()='2']") WebElement cnt_Quantity;
	@FindBy(xpath="//a[normalize-space()='Proceed To Checkout']") WebElement lnk_ProceedtoCheckout;
	@FindBy(xpath="//a[@class='cart_quantity_delete']") WebElement lnk_delete;
	@FindBy(xpath="//b[normalize-space()='Cart is empty!']") WebElement msg_cartempty;
	

	public String verifyQuantity() {
		return cnt_Quantity.getText();
	}
	
	public void clickProceedtoCheckout() {
		lnk_ProceedtoCheckout.click();
	}
	
	public void deleteProduct() {
		lnk_delete.click();
	}
	
	public String msgCartEmpty() {
		String msg = msg_cartempty.getText();
		System.out.println("The message is  "+ msg);
		return msg;
		}
	
	public WebElement msgCartEmptyisDisplayed() {
		
		return msg_cartempty;
}
	}
