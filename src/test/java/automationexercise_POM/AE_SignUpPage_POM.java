package automationexercise_POM;

import java.util.List;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AE_SignUpPage_POM extends AE_commonConstructor_POM {
	
	
	public AE_SignUpPage_POM(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']") WebElement hd_NewUserSignUp;
	@FindBy(xpath="//input[@placeholder='Name']") WebElement txt_Name;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement txt_Email;
	@FindBy(css="button[data-qa='signup-button']") WebElement btn_SignUp;
	@FindBy(id="id_gender1") WebElement rbt_Male;
	@FindBy(id="id_gender2") WebElement rbt_Female;
	@FindBy(id="password") WebElement txt_Password;
	@FindBy(id="days") WebElement dd_Day;
	@FindBy(id="months") WebElement dd_Month;
	@FindBy(id="years") WebElement dd_Year;
	@FindBy(id="first_name") WebElement txt_FirstName;
	@FindBy(id="last_name") WebElement txt_LastName;
	@FindBy(id="address1") WebElement txt_Address;
	@FindBy(id="country") WebElement dd_Country;
	@FindBy(id="state") WebElement txt_State;
	@FindBy(id="city") WebElement txt_City;
	@FindBy(id="zipcode") WebElement txt_ZipCode;
	@FindBy(id="mobile_number") WebElement txt_MobileNo;
	@FindBy(css="button[data-qa='create-account']") WebElement btn_CreateAccount;
	@FindBy(css="h2[data-qa='account-created']") WebElement hd_AccountCreated;
	@FindBy(linkText="Continue") WebElement btn_Continue;
	@FindBy(css="a[href='/logout']") WebElement lnk_Logout;
	
	
	
	
		
	public boolean checkHeadingNewUserSignUp() {
		return hd_NewUserSignUp.isDisplayed();
	}

	
	public void enterName(String name) {
		txt_Name.sendKeys(name);
	}
	
	
	public void enterEmail(String email) {
		txt_Email.sendKeys(email);
	}
	
	public void clickSignUpButton() {
		btn_SignUp.click();
	}
	
	
	public void selectTitle(String Title) {
		
		if (Title=="Male"){
				rbt_Male.click();
				}
		else if (Title=="Female")
		{
			rbt_Female.click();
			}
		}
	


	public void selectMale(String Title) {
		rbt_Male.click();
	}
	
	public void selectFemale(String Title) {
		rbt_Female.click();
	}
	
	public void enterPassword(String Password) {
		txt_Password.sendKeys(Password);
	}
	
	public void selectDOB(String Day,String Month,String Year) {
		Select selectDay = new Select(dd_Day);
		selectDay.selectByContainsVisibleText(Day);
		
		Select selectMonth = new Select(dd_Month);
		selectMonth.selectByContainsVisibleText(Month);
		
		Select selectYear = new Select(dd_Year);
		selectYear.selectByContainsVisibleText(Year);
			}
	
	public void enterFirstName(String fName) {
		txt_FirstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		txt_LastName.sendKeys(lName);
	}
	
	public void enterAddress(String Address) {
		txt_Address.sendKeys(Address);
	}
	
	public void selectCountry(String country) {
		Select selectCountry = new Select(dd_Country);
		selectCountry.selectByContainsVisibleText(country);
	}
	
	public void enterState(String state) {
		txt_State.sendKeys(state);
	}
	
	public void enterCity(String city) {
		txt_City.sendKeys(city);
	}
	
	public void enterZipCode(String zp) {
		txt_ZipCode.sendKeys(zp);
	}
	
	
	public void enterMobileNumber(String mobNo) {
		txt_MobileNo.sendKeys(mobNo);
	}
	
	
	public void clickCreateAccount() {
		btn_CreateAccount.click();
	}
	
	public boolean checkAccountCreation() {
		return hd_AccountCreated.isDisplayed();
	}
	
	public void clickContinue() {
		btn_Continue.click();
	}
	
	public void clickLogout() {
		lnk_Logout.click();
	}
}
