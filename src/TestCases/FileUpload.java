package TestCases;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        String downloadPath = System.getProperty("user.dir");
        
        ChromeOptions options = new ChromeOptions();
        
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        
        //options.addArguments("--test-type");
        //options.addArguments("start-maximized", "disable-popup-blocking");
        
		System.setProperty("webdriver.chrome.driver",
				"C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://altoconvertpdftojpg.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("dropzoneInput-label")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\t169515.CADRA\\eclipse-workspace\\fileUpload.exe"); //Execute the AutoIT exe file
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		
		driver.findElement(By.linkText("Download Now")).click();
		Thread.sleep(5000);
		
		//Verify if file is downloaded
		File f = new File(downloadPath+"/converted.jpg");
		
		if(f.exists())
		{
			System.out.println("File present");
			if(f.delete());
			System.out.println("File deleted");
			}
		


	}

}
