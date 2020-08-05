package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		String searchText = "";
		int j=0;

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("One Plus").build().perform();
		
	   //Extracting hidden text using JS Executor
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		while(!searchText.equalsIgnoreCase("one plus7t pro mobile"))
		{
			j++;
			a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).sendKeys(Keys.DOWN).build().perform();
			String script = " return document.getElementById(\"twotabsearchtextbox\").value;";
			searchText = (String) js.executeScript(script);	
			if(j>10) //To avoid infinite loop if that text is not found. 10 refers to max no of options in list
			{
				break;
			}
		}
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).sendKeys(Keys.ENTER).build().perform();
		System.out.println(searchText);
		
	}

}
