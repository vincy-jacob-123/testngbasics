package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxTestcase {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		driver.manage().window().maximize();
	}
	
	
	@Test(invocationCount = 2)
	public void verify_single_checkBox_header_text() {
		WebElement obj1 = driver.findElement(By.xpath("//div[contains(text(),'Single Checkbox Demo')]"));
		String actualText = obj1.getText();
		String expectedText = "Single Checkbox Demo";
		Assert.assertEquals(actualText, expectedText); 
		System.out.println("Executed test case");
	}
	
	@Test
	public void verify_single_checkBox_label() {
		WebElement obj2 = driver.findElement(By.xpath("//label[contains(text(),'Click on this check box')]"));
		String actualText = obj2.getText();
		String expectedText = "Click on this check box";
		Assert.assertEquals(actualText, expectedText); 
	}
	
	@Test(priority=1, dependsOnMethods = "verify_single_checkBox_label")
	public void verify_multiple_checkBox_header_text() {
		WebElement obj3 = driver.findElement(By.xpath("(//div[@class='card-header'])[3]"));
		String actualText = obj3.getText();
		String expectedText = "Multiple Checkbox Demo";
		Assert.assertEquals(actualText, expectedText,"Failed due to text mismatch"); 
	}
	
	//enabled --> false  --> wont execute that test case
	@Test(priority=2, enabled=false, dependsOnMethods = "verify_multiple_checkBox_header_text")//if -1 & -5, then -5 executes first
	public void verify_single_check_box_displayed() {
		WebElement obj3 = driver.findElement(By.xpath("//input[@class='form-check-input']"));
		//boolean isDisplayed = obj3.isDisplayed();
		//Assert.assertEquals(isDisplayed, true);
		//Assert.assertTrue(isDisplayed); //only for boolean test cases
		Assert.assertTrue(obj3.isDisplayed()); 
	}
	
//	@AfterMethod

}
