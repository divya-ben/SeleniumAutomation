package commonMethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takeSnapshot {

	public static void takeShot(WebDriver driver,String testcase) throws Exception {
		// TODO Auto-generated method stub
		TakesScreenshot scrshot = ((TakesScreenshot)driver);
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\t169515.CADRA\\eclipse-workspace\\EndtoEnd\\reports"+testcase+".png");
		FileUtils.copyFile(srcFile,destFile);

	}

}
