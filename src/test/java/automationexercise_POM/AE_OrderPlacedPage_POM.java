package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_OrderPlacedPage_POM extends AE_commonConstructor_POM{
	
	public AE_OrderPlacedPage_POM(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//p[normalize-space()='Congratulations! Your order has been confirmed!']") WebElement msg_OrderConfMsg;
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement btn_Continue;
	
 public boolean checkConfirmationOrderMsg() {
	 if(msg_OrderConfMsg.getText().equals("Congratulations! Your order has been confirmed!"))
		 System.out.println("Congratulations! Your order has been confirmed!");
	 else if(msg_OrderConfMsg.isDisplayed()) {
		 System.out.println("Messag: Your order has been confirmed! is displayed");
	 }
	 return true;
}
 
 public void clickContinue() {
	 btn_Continue.click();
 }


	
}
