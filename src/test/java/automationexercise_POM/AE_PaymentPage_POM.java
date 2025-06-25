package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_PaymentPage_POM extends AE_commonConstructor_POM{
	
	public AE_PaymentPage_POM(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@name='name_on_card']") WebElement txt_NameonCard;
	@FindBy(xpath="//input[@name='card_number']") WebElement txt_CardNumber;
	@FindBy(xpath="//input[@placeholder='ex. 311']") WebElement txt_CVC;
	@FindBy(xpath="//input[@placeholder='MM']") WebElement txt_Expiration;
	@FindBy(xpath="//input[@placeholder='YYYY']") WebElement txt_Year;
	@FindBy(xpath="//button[@id='submit']") WebElement btn_PlaceOrder;
	
	public void enterNameonCard() {
		txt_NameonCard.sendKeys("TesterSG");
	}
	
	public void enterCardNumber() {
		txt_CardNumber.sendKeys("1234123412341234");
	}
	
	public void enterCVC() {
		txt_CVC.sendKeys("321");
	}
	
	public void enterExpiration() {
		txt_Expiration.sendKeys("10");
			}
	
	public void enterYear() {
		txt_Year.sendKeys("2027");
	}
	
	public void clickPlaceOrder() {
		btn_PlaceOrder.click();
	}
	

}
