package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_ProductDetailsPage_POM  extends AE_commonConstructor_POM{
	
	public AE_ProductDetailsPage_POM(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='Sleeveless Dress']" ) WebElement pdt_SleevelessDress;
	@FindBy(id="quantity") WebElement txt_Quantity;
	@FindBy(xpath="//button[normalize-space()='Add to cart']") WebElement btn_AddtoCart;
	@FindBy(xpath="//h4[normalize-space()='Added!']") WebElement msg_ModalConfmsg;
	@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement lnk_viewCart;
	@FindBy(xpath="//button[normalize-space()='Continue Shopping']") WebElement lnk_continueShopping;
	
	public void checkSleevelessDress() {
		pdt_SleevelessDress.getText();
	}
	public void enterQuantity() {
		txt_Quantity.clear();
		txt_Quantity.sendKeys("2");
			}
	
	public void clickAddtoCart() {
		btn_AddtoCart.click();
	}
	
	public String checkProductAddedMessage() {
		return msg_ModalConfmsg.getText();
	
	}
	
	public void clickViewCart() {
		lnk_viewCart.click();
	}
	
	public void clickContinueShopping() {
		lnk_continueShopping.click();
	}
}
