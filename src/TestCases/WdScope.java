package TestCases;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WdScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int size = driver.findElements(By.tagName("a")).size();
		
		//Get no of links in the footer section
		//Step 1 - Minimizing scope to footer
		WebElement footdriver = driver.findElement(By.xpath("//*[@id='gf-BIG']"));
		
		//Step 2 - Get no of links only in footer
		int footLinks = footdriver.findElements(By.tagName("a")).size();
		
		//Get no of links only in 1st column of footer
		WebElement colDriver = footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int colLinks = colDriver.findElements(By.tagName("a")).size();
		
		//Click each link in the footer
		for (int i=1;i<colLinks;i++)
		{
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER); //Ctrl + Enter will open link in separate tab
			colDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
	    
		//Print titles of all tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
		
		

	}

}
