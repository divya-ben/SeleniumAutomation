package TestCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Will be applied to all statements. //Cannot be used in places where performance of specific elements is to be checked
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] items1 = {"Brocolli", "Cucumber", "Carrot"};

		// Declaring Arraylist
		ArrayList<String> items = new ArrayList<String>();
		items.add("Brocolli");
		items.add("Cucumber");
		
		addItems(driver,items1);

	}
	
	public static void addItems(WebDriver driver, String[] items1) {
		

		int count = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		WebDriverWait w = new WebDriverWait(driver,5);
		
		System.out.println(products.size());
		
		for (int i = 0; i < products.size(); i++) {
			String[] names = products.get(i).getText().split("-");
			String formattedName = names[0].trim();
			// Convert list to array list. Declare as list because it occupies less memory
			// space and then convert it to array during runtime
			List itemsNeeded = Arrays.asList(items1);

			if (itemsNeeded.contains(formattedName)) {
				count++;
				/*driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); 
				Avoid using text as a locator since it can be dynamic*/
				
				//Get the exact xpath of the button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if (count > itemsNeeded.size())
					break;
			}
		}
		
		driver.findElement(By.xpath("//*[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		String status = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		System.out.println(status);
	}

}
