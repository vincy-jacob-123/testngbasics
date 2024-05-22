package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class softAssertExample {
	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	//check
	@BeforeMethod
	public void before_method() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/window-popup.php");
		
		driver.manage().window().maximize();	
		
	}
	
	@Test
	public void verify_LikeUsOnFacebook_text_title() {		
		
		WebElement obj = driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		String actualText = obj.getText();
		String exepctedText = "Like us On Facebook";
		softAssert.assertEquals(actualText, exepctedText);
		
		String actualTitle = obj.getAttribute("title");
		String exepctedTitle = "Follow @obsqurazone on Facebook";
		softAssert.assertEquals(actualTitle, exepctedTitle);	
		softAssert.assertAll(); //without this, it shows that text case passed though it fails
	}

}
