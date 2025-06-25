package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_LoginPage_POM extends AE_commonConstructor_POM {
		
	public AE_LoginPage_POM(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css="input[data-qa='login-email']") WebElement txt_Loginemail;
	@FindBy(css="input[data-qa='login-password']") WebElement txt_Loginpassword;
	@FindBy(css="button[data-qa='login-button']") WebElement btn_Loginbutton;
	@FindBy(css="a[href='/logout']") WebElement lnk_Logout;
	
	@FindBy(xpath="//a[contains(text(),'Logged in as')]") WebElement msg_Login;
	
	
	
	public void enterLoginemail(String email) {
		txt_Loginemail.sendKeys(email);		
	}
	
	public void enterLoginpassword(String password) {
		txt_Loginpassword.sendKeys(password);
	}
	
	public void clickLoginbutton() {
		btn_Loginbutton.click();
	}
	
	public String verifyLoginsuccessmsg() {
		return msg_Login.getText();
	//	return msg_Login.isDisplayed();

	}
	
	public boolean verifyLogoutlinkPresence() {
		return lnk_Logout.isDisplayed();

	}
}


