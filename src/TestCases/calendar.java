package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		
		//Check for common attribute for all days and use it
		List<WebElement> days = driver.findElements(By.className("day"));
		
		//Get month
		String monthSelected = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText();
		//System.out.print(monthSelected);
		
		while(!monthSelected.contains("April"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
			monthSelected = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText();
			System.out.print(monthSelected);
		}

		
		for(int i=0;i<days.size();i++)
		{
			String dayCurrent = driver.findElements(By.className("day")).get(i).getText();
			if(dayCurrent.equals("23"))
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}	
		}
		
		
		
		
		
		/*for(WebElement month : months)
		{
			int i=0;
			if(month.getText().contains("April"))
			{
				months.get(i).click();
				break;
			}
			i++;
		}*/

	}

}
