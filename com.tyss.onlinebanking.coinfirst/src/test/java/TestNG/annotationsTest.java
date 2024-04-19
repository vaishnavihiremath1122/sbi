package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class annotationsTest {
		
	@Test
	public void oneTest() {
		System.out.println("Test script-1");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("launching browser");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("login to application");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Test script-2 ");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("connect to database");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("logout to application");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("close database connection");
	}
	
	@Test
	public void thirdTest() {
		System.out.println("Test script-3");
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("launch second browser");
	}
	
	@AfterMethod
	public void afterMethod2() {
		System.out.println("close second browser");
	}
	
	
	
	
	
	
	
	
}
