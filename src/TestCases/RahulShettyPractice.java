package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RahulShettyPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String text = "Divya";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		driver.switchTo().alert().getText(); //Get alert text
		driver.switchTo().alert().accept(); //Accept alerts. When you want to click on ok
		
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		driver.switchTo().alert().dismiss(); // When you want to click No or Cancel for an alert
		
		driver.findElement(By.id("OneWay")).click();
		driver.findElement(By.id("FromDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		Select adt = new Select(driver.findElement(By.name("adults"))); //only for lists using Select tag
	    adt.selectByValue("2");
	    
	    Select chd = new Select(driver.findElement(By.name("childs")));
	    chd.selectByValue("2");
	    
	    driver.findElement(By.id("MoreOptionsLink")).click();
	    driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
	    
	    driver.findElement(By.id("SearchBtn")).click();
	    
	    String error = driver.findElement(By.xpath("//div[@id='homeErrorMessage'")).getText();
	    System.out.print(error);

	    
		
		
		
		

	}

}
