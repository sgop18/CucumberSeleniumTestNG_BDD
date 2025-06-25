package automationexercise_StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utils.TakeScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AE_Hooks  {


	public static WebDriver driver;
	public static Properties p;

	public static WebDriver getDriver() {
		return driver;
	}

	@Before(order = 1)
	public void setup() throws IOException {
		String basepath=System.getProperty("user.dir");
		System.out.println("Basepath "+basepath);
		System.setProperty("webdriver.chrome.driver", basepath+"/src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.edge.driver", basepath+"/src/test/resources/drivers/msedgedriver.exe");

		String configFilePath = basepath+"/src/test/resources/config.properties";
		FileInputStream file = new FileInputStream(configFilePath);
		p=new Properties();
		p.load(file);

		String browser = p.getProperty("browser");

		switch(browser.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver();break;
		default: System.out.println("invalid browser");return;
		}
	}

	@Before(order = 2)
	public void openWebpage() {
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
	
	@After(order=1)
	public void onScenarioFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			
		scenario.attach(TakeScreenshot.takeScreenshotsinByte(driver), "image/png", scenario.getName());
		}
	}
			
	/*@After(order=1)
	public void takeScreenshotonFailure(Scenario scenario) {
		
		Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String formattedDate = df.format(date);
       // String screenshotDir = System.getProperty("user.dir") + "/target/screenShots/";
       // String ssPath = screenshotDir + "Screenshot_" + formattedDate + ".png";
        
        
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			//ts.getScreenshotAs(OutputType.BASE64);
			//ts.getScreenshotAs(OutputType.FILE);
			String strname = "Screenshot_" + formattedDate;
			scenario.attach(screenshot, "image/png",strname);
		}
		
	}
	*/
	@After(order=0)
	public void teardown() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(5));
		driver.close();
		driver.quit();
			}

}
