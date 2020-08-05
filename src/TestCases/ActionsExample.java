package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		WebElement account = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		Actions a = new Actions(driver);
		
		//Move to specific element and hover
		a.moveToElement(account).build().perform();
		
		//Move to element, click, enter text in capital
		//a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Oneplus").doubleClick().build().perform();
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Oneplus").build().perform();
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='nav-iss-attach']"));
		
		for (WebElement option : options)
		{
			System.out.println(option.getText());
		}
		
		//Right click
		//a.moveToElement(account).contextClick().build().perform();
		

	}

}
