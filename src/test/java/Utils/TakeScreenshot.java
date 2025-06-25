package Utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static byte[] takeScreenshotsinByte(WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot)driver;
				return ss.getScreenshotAs(OutputType.BYTES);
	}
	
	
	
	public static String takeScreenshotsreturnsPath(WebDriver driver) {
		String ssPath=System.getProperty("user.dir") +"/target/screenshots.png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcSS = ts.getScreenshotAs(OutputType.FILE);
		File tgtSS = new File(ssPath);
		srcSS.renameTo(tgtSS);
		return ssPath;
		
		}
}
