package TestCases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonMethods.takeSnapshot;

public class MultipleWindow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.linkText("Help")).click();
		
		//Get all windows
		Set<String> ids = driver.getWindowHandles();
		
		//Iterate all window handles
		Iterator<String> it = ids.iterator();
		
		//Get parent handle
		String parent = it.next();
		
		//Get 1st child window handle
		String child = it.next();
		
		driver.switchTo().window(child);
		driver.findElement(By.name("q")).sendKeys("Test");
		takeSnapshot.takeShot(driver, "C:\\Users\\t169515.CADRA\\Downloads\\Selenium notes\\Parent.png");
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.id("firstName")).sendKeys("Divya");
		takeSnapshot.takeShot(driver, "C:\\Users\\t169515.CADRA\\Downloads\\Selenium notes\\Child.png");
		
		

	}

}
