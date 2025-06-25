package automationexercise_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AE_ProductsPage_POM extends AE_commonConstructor_POM {

	public AE_ProductsPage_POM(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@href='/products']")WebElement lnk_Products;
	@FindBy(xpath="//input[@id='search_product']")WebElement txt_SearchBox;
	@FindBy(id="submit_search") WebElement btn_Search;
	@FindBy(xpath="//a[normalize-space()='Women']") WebElement exp_WomenCategory;
	@FindBy(xpath="//div[@id='Women']//a[contains(text(),'Dress')]") WebElement lnk_Dress;
	@FindBy(xpath="//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]") WebElement lnk_ViewProduct1;
	@FindBy(css="div.productinfo.text-center > p") List<WebElement> productNames;
	
	public void clickProductsLink() {
		lnk_Products.click();
	}
	
	public void searchProduct() {
		txt_SearchBox.sendKeys("Dress");
	}
	
	public void clickSearchIcon() {
		btn_Search.click();
	}
	
	public void expandCategoryWomen() {
		exp_WomenCategory.click();
	}
	
	public void clickDress() {
		lnk_Dress.click();
	}
	
	public void viewProduct() {
		lnk_ViewProduct1.click();
	}
	
	public List<WebElement> productNames(){
		return productNames;
		
	}
	
	
}
