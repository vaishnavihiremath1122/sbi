package customer;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.DataBaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.genericUtility.fileUtility;
//import com.onlinebanking.creditcoin.objectrepsitory.ApprpveAccount;
import com.onlinebanking.creditcoin.objectrepsitory.ApprpveAccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Homepage;
import com.onlinebanking.creditcoin.objectrepsitory.Openaccountpage;
//@Listeners(com.genericUtility.ListenerImplementation.class)
public class customerOpenAccountTest extends BaseClass {
	
	
	@Test(groups="smoke")
	 
	public  void openAccAndApproveByStaff() throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
		
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL1 = futil.readDataFromPropertyFile("url1");
		String URL = futil.readDataFromPropertyFile("url");
		
		
		Homepage homepage=new Homepage(driver);
		Openaccountpage openaccountpage=new Openaccountpage(driver);
		ApprpveAccountpage apprpveaccount = new ApprpveAccountpage(driver);
		
		//open account
		Random r=new Random();
		int num = r.nextInt(400);
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver, num);
		
		driver.get(URL1);
		openaccountpage.enteropenaccbtn();
		
		String name = eutil.readDataFromExcel("customer", 0, 1);
		String gender = eutil.readDataFromExcel("customer", 1, 1);
		String mbno=eutil.readDataFromExcel("customer", 2, 1);
		String email=eutil.readDataFromExcel("customer", 3, 1);
		String landlineno=eutil.readDataFromExcel("customer", 4, 1);
		String panno=eutil.readDataFromExcel("customer", 5, 1);
		String citizenship=eutil.readDataFromExcel("customer", 6, 1);
		String homeaddress=eutil.readDataFromExcel("customer", 7, 1);
		String officeaddress=eutil.readDataFromExcel("customer", 8, 1);
		String state=eutil.readDataFromExcel("customer", 9, 1);
		String city=eutil.readDataFromExcel("customer", 10, 1);
		String pinno=eutil.readDataFromExcel("customer", 11, 1);
		String area=eutil.readDataFromExcel("customer", 12, 1);
		String accountype =eutil.readDataFromExcel("customer", 13, 1);
		
		
		
		//sending the data
		
		openaccountpage.enternametxt(name) ;
		//driver.findElement(By.name("name")).sendKeys(name);
		openaccountpage.enterGendertxt(gender, wutil);
		//WebElement ele = driver.findElement(By.name("gender"));
		//wutil.selectbyvisibletexts(ele, gender);
		openaccountpage.entermblnotxt(mbno);
		//driver.findElement(By.name("mobile")).sendKeys(mbno);
		openaccountpage.enteremailtxt(email);
		//driver.findElement(By.name("email")).sendKeys(email);
		openaccountpage.enterlandlinetxt(landlineno);
		//driver.findElement(By.name("landline")).sendKeys(landlineno);
		//driver.findElement(By.name("dob")).click();
		openaccountpage.enterdobtxt();
		wutil.robotObj();
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_1);
		rt.keyPress(KeyEvent.VK_2);
		rt.keyPress(KeyEvent.VK_0);
		rt.keyPress(KeyEvent.VK_2);
		rt.keyPress(KeyEvent.VK_2);
		rt.keyPress(KeyEvent.VK_0);
		rt.keyPress(KeyEvent.VK_2);
		rt.keyPress(KeyEvent.VK_2);
		
		
		openaccountpage.enterpannotxt(panno);
		//driver.findElement(By.name("pan_no")).sendKeys(panno);
		openaccountpage.entercitizenshiptxt(citizenship);
		//driver.findElement(By.name("citizenship")).sendKeys(citizenship);
		openaccountpage.enterhomeadrestxt(homeaddress);
		//driver.findElement(By.name("homeaddrs")).sendKeys(homeaddress);
		openaccountpage.enterofficeaddtxt(officeaddress);
		//driver.findElement(By.name("officeaddrs")).sendKeys(officeaddress);
		
		openaccountpage.enterstatedd(state);
		//WebElement ele1 = driver.findElement(By.name("state"));
		//wutil.selectbyvisibletexts(ele1, state);
		openaccountpage.entercitydd(city);
	//	 WebElement ele2 = driver.findElement(By.name("city"));
	//	wutil.selectbyvisibletexts(ele2,city );
		
		openaccountpage.enterpintxt(pinno);
		//driver.findElement(By.name("pin")).sendKeys(pinno);
		
		openaccountpage.enterarealoctxt(area);
		//driver.findElement(By.name("arealoc")).sendKeys(area);
		openaccountpage.acctypedd(accountype);
		
		//driver.findElement(By.name("acctype")).sendKeys(accountype);
		  
		openaccountpage.submitbtn();
	  // driver.findElement(By.name("submit")).click();
		
		openaccountpage.cnfrmbtn();
	  // driver.findElement(By.name("cnfrm-submit")).click();
	  
		
	   String confirmPopup 	 = driver.switchTo().alert().getText();
	 //getting application number
	   
	   
	   
	   String[] lines = confirmPopup.split("\\r?\\n");
	   System.out.println(Arrays.toString(lines));
		// Search for the line containing the application number
		String applicationNumber ="";
		for (String line : lines) {
			if (line.startsWith("Application number :")) {
				// Split the line to get the application number
				String[] parts = line.split(":");
				// Extract the application number string
				String applicationNumberStr = parts[1].trim();
				// Parse the application number string to integer
				applicationNumber = applicationNumberStr;

				break; // Break the loop once the application number is found
			}
		}
		System.out.println(applicationNumber);
		wutil.acceptAlert(driver);
		driver.get(URL);
		homepage.staffidtxtf(USERNAME);
		homepage.passwordtxtf(PASSWORD);
		homepage.loginbtn();
		apprpveaccount.enterapprvacbtn();
	    apprpveaccount.enterapplicationtxt(applicationNumber);
	    apprpveaccount.entersearchbtn();
		apprpveaccount.enterapprove();
		
	//	Assert.fail();
		
		String accno = "";
		String text = driver.switchTo().alert().getText();
		for (int i=0;i<text.length();i++) {
			if(Character.isDigit(text.charAt(i)))
		{
				accno+=text.charAt(i);
		}
	 }
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(accno);
	 }
}
