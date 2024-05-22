package testngAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void launch_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/bootstrap-alert.php");
		driver.manage().window().maximize();		
	}
	
	@Test
	public void verify_bootstrap_header() {
		
		WebElement header = driver.findElement(By.xpath("//div[contains(text(),'Bootstrap Alert')]"));
		String expectedText = "Bootstrap Alert";
		String actualText = header.getText();		
		softAssert.assertEquals(actualText, expectedText);
		
		
		WebElement alert = driver.findElement(By.xpath("//button[@id='autoclosable-btn-warning']"));
		String actualColour = alert.getCssValue("background-color");
		String expectedColour = "rgba(255, 193, 7, 1)";
		System.out.println("colour:" +alert.getCssValue("background-color") );
		softAssert.assertEquals(actualColour, expectedColour);
		softAssert.assertAll();
	}

}
