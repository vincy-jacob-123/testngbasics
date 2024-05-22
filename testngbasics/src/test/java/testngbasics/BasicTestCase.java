package testngbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager; //no need to download driver locally with this class


public class BasicTestCase {	
	
	WebDriver driver;
	
	@BeforeMethod
	public void launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//implicit wait if needed can be provided here
	}
	
	@Test
	public void verify_title() {
		System.out.println(System.getProperty("user.dir")); //to find the testcase result path
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualTitle, expectedTitle); //assertion	
		//Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void verify_url() {
		String actualUrl= driver.getCurrentUrl();
		String expectedUrl = "https://www.amazon.in/";
		Assert.assertEquals(actualUrl, expectedUrl); //assertion	
		//Assert.assertEquals(expectedTitle, actualTitle);
	}


}
