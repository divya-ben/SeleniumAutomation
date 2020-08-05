package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		
		String searchText = "";
		String searchTextNew = "";
		int i=0;
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		while(!searchText.equalsIgnoreCase("india"))
		{
			i++;
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			String script = " return document.getElementById(\"autocomplete\").value;";
			searchText = (String) js.executeScript(script);	
			
			//Alternate way to get the text
			searchTextNew = driver.findElement(By.id("autocomplete")).getAttribute("value");
			
			if (i>10)
			{
				break;
			}
		}
		
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
		
		if(searchText.equalsIgnoreCase("India"))
		{
			System.out.println("Pass");
		}
		
		System.out.println(searchText);
		System.out.println(searchTextNew);

	}

}
