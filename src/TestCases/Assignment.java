package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement check = driver.findElement(By.id("checkBoxOption1"));
		String option = check.getAttribute("value");
		check.click();
		
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(option);
		
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
		
		if(alertText.contains(option))
		{
			System.out.print("Pass");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		

	}

}
