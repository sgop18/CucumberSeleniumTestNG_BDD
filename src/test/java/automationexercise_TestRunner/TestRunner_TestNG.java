package automationexercise_TestRunner;
//"src/test/resources/features/AE_Testcases__CartFunctions_TestNG.feature"
//"src/test/resources/features/AE_NewUserRegistration.feature"

//"src/test/resources/features/AE_UserLogin.feature"
//"src/test/resources/features/AE_EndtoEnd_Product_PlaceOrder.feature"


import java.util.Date;


import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions( features = {
							"src/test/resources/features/AE_NewUserRegistration.feature"
							},
					glue={"automationexercise_StepDefinitions"},
					monochrome=true,
					dryRun=false,
							plugin = 	 
						{
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",					 	 
							"pretty", "html:target/HtmlReports/automationexerciseReport.html",
							"json:target/JSONReports/automationexerciseReport.json",
							"junit:target/JUNITReports/automationexerciseReport.xml",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}		
				)
public class TestRunner_TestNG extends AbstractTestNGCucumberTests{

	static {
        System.out.println(">>>>> TestRunner_TestNG is initialized <<<<<");
    }
	/*@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}


