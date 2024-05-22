package testngAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import testngbasics.Dataproviders;

public class DataProviderSample1 {
	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/table-filter.php");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "members", dataProviderClass = DataProvidersSet1.class)
	public void verfiy_member_presence(String memberName) {
		WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
		searchField.sendKeys(memberName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	//a[@id='example_previous']")));
		String expectedMemberName = memberName;
		String actualMemberName = driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
		System.out.println("Actual Member name:" + actualMemberName);
		softAssert.assertEquals(actualMemberName, expectedMemberName);
		softAssert.assertAll();
	}

}
