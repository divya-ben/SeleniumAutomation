package TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.takeSnapshot;
public class SearchTest {

	public WebDriver driver;
	

	
	@BeforeTest
	public void Setup() {
		
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		System.out.print("Open browser");
	}
	
	@Test
	public void Search() throws Exception {
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Selenium tutorial");
		
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//*[@class='sbl1']"));
		
		for (WebElement option : options)
		{
			System.out.println(option.getText());			
			if(option.getText().equalsIgnoreCase("selenium tutorial")) {
				Assert.assertEquals(option.getText(), "selenium tutorial");
				//driver.findElements(By.cssSelector("input[type= 'checkbox']")).size();
				//driver.findElement(By.id("Div1")).getAttribute("style");//Get style attribute of div tag
				option.click();
				takeSnapshot.takeShot(driver, "C:\\Users\\t169515.CADRA\\Downloads\\Selenium notes\\Screenshot1.png");
				break;
			}
			
		}
		
		//options.forEach(x -> System.out.println(x.getText()) );    
	   /* Select s = new Select(driver.findElement(By.id(""))); //only for lists using Select tag
	    s.selectByVisibleText("Text");
	    s.selectByValue("Option tag value");
	    s.selectByIndex(1);*/

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.print("Success");
	}
}
