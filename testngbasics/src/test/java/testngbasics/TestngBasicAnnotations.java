package testngbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasicAnnotations {
	
	@BeforeSuite
	public void before_suite() {
		System.out.println("Invoking @BeforeSuite");		
	}
	
	@BeforeTest
	public void before_test() {
		System.out.println("Invoking @BeforeTest");		
	}

	
	@BeforeClass
	public void before_class() {
		System.out.println("Invoking @BeforeClass");		
	}
	
	@BeforeMethod
	public void before_method() {
		System.out.println("Invoking @BeforeMethod");		
	}
	
//	@Test
//	public void test1Execution() {
//		System.out.println("Invoking Test case 1");		
//	}
//	
//	@Test
//	public void test2Execution() {
//		System.out.println("Invoking Test case 2");		
//	}
	
	@AfterMethod
	public void after_method() {
		System.out.println("Invoking @AfterMethod");		
	}
	
	@AfterClass
	public void after_class() {
		System.out.println("Invoking @AfterClass");		
	}
	
	@AfterTest
	public void after_test() {
		System.out.println("Invoking @AfterTest");		
	}
	
	@AfterSuite
	public void after_suite() {
		System.out.println("Invoking @AfterSuite");		
	}	
}
