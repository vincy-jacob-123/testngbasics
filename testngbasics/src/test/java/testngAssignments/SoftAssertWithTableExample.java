package testngAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertWithTableExample {
	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-pagination.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verfiy_table_header_and_member_presence() {
		WebElement header = driver.findElement(By.xpath("//div[contains(text(),'Table with Pagination Example')]"));
		String expectedText = "Table with Pagination Example";
		String actualText = header.getText();
		softAssert.assertEquals(actualText, expectedText);
		
		WebElement searchButton = driver.findElement(By.xpath("//a[@href='table-filter.php']"));
		searchButton.click();
		WebElement memberSearch = driver.findElement(By.xpath("//input[@type='search']"));
		memberSearch.sendKeys("Tiger Nixon");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	//a[@id='example_previous']")));
		//without wait also, it works
		WebElement memberName = driver.findElement(By.xpath("//tbody//tr//td[1]"));
		String actualMemberName = memberName.getText();
		String expectedMemberName = "Tiger Nixon";
		softAssert.assertEquals(actualMemberName, expectedMemberName);	
		softAssert.assertAll();
	}
}
