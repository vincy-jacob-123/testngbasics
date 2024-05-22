package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataproviderSample {
	
	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void before_method() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://www.amazon.in/");
//		driver.manage().window().maximize();		
	}
	
	@Test(dataProvider = "amazonProducts", dataProviderClass = Dataproviders.class)
	public void verify_LikeUsOnFacebook_text_title(String product) {
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();	
		WebElement obj = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		System.out.println("Product name::" + product );
		obj.sendKeys(product + Keys.ENTER);
		
//		obj.sendKeys("headset");
//		WebElement obj1 = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
//		obj1.click();
		
	}
	
	@Test(dataProvider = "facebookLoginData", dataProviderClass = Dataproviders.class)
	public void verify_facebook_login(String username, String password) {
		 	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();	
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		//email.sendKeys("vincyjacob27@gmail.com");
		email.sendKeys(username);
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
		//passwordField.sendKeys("vinmaria27" + Keys.ENTER);
		passwordField.sendKeys(password);
		
		WebElement loginButtoin = driver.findElement(By.xpath("//button[@name='login']"));
		loginButtoin.click();
		
				
	}

}
