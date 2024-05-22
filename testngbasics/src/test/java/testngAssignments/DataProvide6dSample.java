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

public class DataProvide6dSample {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/form-submit.php");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "memberData", dataProviderClass = DataProvidersSet1.class)
	public void verfiy_member_data_submission(String firstName, String lastName, String username, String city, String state, String pin) {
		WebElement firstNameObj = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		firstNameObj.sendKeys(firstName);
		WebElement SeconfNameObj = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		SeconfNameObj.sendKeys(lastName);
		WebElement userNameObj = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		userNameObj.sendKeys(username);
		WebElement citObj = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		citObj.sendKeys(city);
		WebElement stateObj = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		stateObj.sendKeys(state);
		WebElement pinObj = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		pinObj.sendKeys(pin);
		WebElement agreeCheckBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		agreeCheckBox.click();
		
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit form']"));
		submit.click();
		WebElement submitMsg= driver.findElement(By.xpath("//div[@id='message-one']"));
			
		
		String expectedSubmitMessage = "Form has been submitted successfully!";
		String actualSubmitMessage = submitMsg.getText();
		System.out.println("actualSubmitMessage:" + actualSubmitMessage);
		softAssert.assertEquals(actualSubmitMessage, expectedSubmitMessage);
		softAssert.assertAll();
	}
}
