package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GridTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22871/rsau19-vs-indu19-1st-youth-odi-match-quadrangular-u19-series-in-south-africa-2020");
		
		//Identify the table
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		ArrayList<String> scores = new ArrayList<String>();
		double sum=0;
		double actualTotal;

		//Find the number of rows
		int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		
		//Score is the 3rd child of the row. Take the 3rd column within the row
		int colCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		
		//Traverse each row and take the score. Ignore the last 2 because they are not scores.
		//Store in array list
		for(int i=0;i<colCount-2;i++)
		{
			scores.add(table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
		}
		
		System.out.println(scores);
		
		//Total score
		for(int i=0;i<scores.size();i++)
		{
			sum += Integer.parseInt(scores.get(i));
			
		}
		System.out.println("Sum"+sum);
		
		//Navigate to Extras and print the element next to it
		String extra = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		
		sum+=Integer.parseInt(extra);
		System.out.println("SUM" +sum);
		
		actualTotal = Integer.parseInt(driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
		
		if(sum==actualTotal)
		{
			System.out.println("Count matches");
		}
		
		

	}

}
