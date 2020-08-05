package TestCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SortProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//How to check if column values are sorted
		
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		ArrayList<String> siteVeggies = new ArrayList<String>();
		ArrayList<String> sortedVeggies = new ArrayList<String>();
		ArrayList<String> sortedVeggiesDesc = new ArrayList<String>();
		
		List<WebElement> veggies; 
        veggies = driver.findElements(By.cssSelector("tr td:nth-child(2)")); //Get only the 2nd column
		
	    for(int i=0;i<veggies.size();i++)
	    {
	    	siteVeggies.add(veggies.get(i).getText());
	    }
	    
	    //Create new sorted list
	    
	    for(String veggie : siteVeggies)
	    {
	    	sortedVeggies.add(veggie);
	    }
	    
	    siteVeggies.clear();
	    //Assert.assertTrue(siteVeggies.equals(sortedVeggies));
	    
	    driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
	    veggies = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
	    
	    for(int i=0;i<veggies.size();i++)
	    {
	    	siteVeggies.add(veggies.get(i).getText());
	    }
	    
	    Collections.sort(sortedVeggies,Collections.reverseOrder()); //Desc order
	    
	    //Assert.assertTrue(siteVeggies.equals(sortedVeggies));
	    
	    System.out.println("Descending sorting"+sortedVeggies);
	    System.out.println("Descending original"+siteVeggies);
	    
	    siteVeggies.clear();
	    
	    driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
	    veggies = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
	    
	    for(int i=0;i<veggies.size();i++)
	    {
	    	siteVeggies.add(veggies.get(i).getText());
	    }
	    
	    Collections.sort(sortedVeggies); //Asc order

	    
	    //Assert.assertTrue(siteVeggies.equals(sortedVeggies));
	    
	    System.out.println("Ascending sorting"+sortedVeggies);
	    System.out.println("Ascending original"+siteVeggies);
	    
	    
	    Collections.reverse(sortedVeggies); //Reverse elements in an arraylist
	    
	    System.out.println("Descending reverse"+sortedVeggies);

	    
	   
		

	}

}
