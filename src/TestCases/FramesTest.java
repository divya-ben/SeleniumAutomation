package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		
		//Switch to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement dest = driver.findElement(By.cssSelector("div[id='droppable']"));
		
		Actions a = new Actions(driver);
		
		a.dragAndDrop(source, dest).build().perform();
		
		//Find number of frames
		int frameSize = driver.findElements(By.tagName("iframe")).size();
		
		//Switch back to window
		driver.switchTo().defaultContent();
		
		/*Nested frames
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name='frameset-middle']/frame[@name='frame-middle']")));
		String text = driver.findElement(By.cssSelector("div[id='content']")).getText();
		System.out.print(text);
		*/
		
		

	}

}
