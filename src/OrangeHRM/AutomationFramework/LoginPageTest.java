package OrangeHRM.AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageTest {

	public WebDriver driver;
	private static String baseurl = "https://gat-ite.klm.com";
	
	public static void main(String[] args) throws Exception {
	
		WebDriver driver = new FirefoxDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(6000);
	    driver.findElement(By.id("username")).sendKeys("k900206");
	    driver.findElement(By.id("submitInputImmNameId")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.id("inputPassName")).sendKeys("Chennai7");
	    driver.findElement(By.id("submitInputAutId")).click();
	    Thread.sleep(30000);
	    driver.findElement(By.id("searchText")).sendKeys("KL");
	    
	}
}
