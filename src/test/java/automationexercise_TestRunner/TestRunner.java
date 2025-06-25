package automationexercise_TestRunner;
//"src/test/resources/features/AE_Testcases__CartFunctions_TestNG.feature

//"src/test/resources/features/AE_NewUserRegistration.feature"

//"src/test/resources/features/AE_UserLogin.feature"
//"src/test/resources/features/AE_EndtoEnd_Product_PlaceOrder.feature"


import java.util.Date;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions( features = {
			"src/test/resources/features/AE_NewUserRegistration.feature"
							},
					glue={"automationexercise_StepDefinitions"},
					monochrome=true,
					dryRun=false,
							plugin = 	 
						{
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
					/*plugin = 	 
							{"pretty", "html:target/HtmlReports/automationexerciseReport.html",
							"json:target/JSONReports/automationexerciseReport.json",
							"junit:target/JUNITReports/automationexerciseReport.xml",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	*/		
				)
public class TestRunner{


}


