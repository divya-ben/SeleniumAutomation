package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SslCertificates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\t169515_Copy\\DIVYA_PROJECTS\\AUTOMATION TRAINING\\chromedriver_win64\\chromedriver.exe");
		
		//Define the capability - General chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		
		//Alternate method
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//Pass the capability to Chrome options
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		
		//Pass the profile to Chrome driver
		WebDriver driver = new ChromeDriver(c);
		
		//Delete cookies
		driver.manage().deleteAllCookies();
		
		//Delete session cookie for logout
		driver.manage().deleteCookieNamed("sessionId");//session cookie name
		
		driver.get("https://www.google.com");
		
	
		
		

	}

}
