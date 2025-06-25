package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_HomePage_POM extends AE_commonConstructor_POM {
	
	
	//constructor
	public AE_HomePage_POM(WebDriver driver) {
		super(driver);
	}

	//locators
	
	@FindBy(css="a[href='/login']") WebElement lnk_Signup;
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]") WebElement lnk_Cart;
	
	
		
	//action methods
	
	public void clickSignup() {
		lnk_Signup.click();
	}
	
	public void clickLogin() {
		lnk_Signup.click();
	}
	
	public void clickCart() {
		lnk_Cart.click();
	}
}
