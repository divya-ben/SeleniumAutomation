package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement table = driver.findElement(By.id("product"));
		
		int rowCount = table.findElements(By.tagName("tr")).size();
		int colCount = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
		
		
		System.out.println("Rowcount"+rowCount);
		System.out.println("Column count"+colCount);
		
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
		
		
		for(int i=0;i<secondrow.size();i++)
		{
		    
			System.out.println(secondrow.get(i).getText());	
			//System.out.println(driver.findElements(By.tagName("tr")).get(i).getText());
				//break;
		}
		
	}

}
