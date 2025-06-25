package automationexercise_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AE_commonConstructor_POM {
	WebDriver driver;
	
	public AE_commonConstructor_POM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
