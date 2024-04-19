package customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.BaseClass;
import com.genericUtility.DataBaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.genericUtility.fileUtility;

public class custromerOpenAccountUtilityTest extends BaseClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
		WebDriverUtility wutil=new WebDriverUtility();
		ExcelUtility eutil=new ExcelUtility();
		fileUtility futil=new fileUtility();
		DataBaseUtility dbutil=new DataBaseUtility();
		JavaUtility jutil=new JavaUtility();
		
		WebDriver driver=null;
		
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		Random r=new Random();
		int num = r.nextInt(400);
		//open account
		
		driver = new ChromeDriver();
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver, num);
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/index.php");
		//getting the data from eutility class
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
		//WebElement openaccont = driver.findElement(By.xpath("//li[text()='Open Account']"));
		driver.findElement(By.name("name")).sendKeys(name);
		WebElement ele = driver.findElement(By.name("gender"));
		wutil.selectbyvisibletexts(ele, gender);
		driver.findElement(By.name("mobile")).sendKeys(mbno);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("landline")).sendKeys(landlineno);
		driver.findElement(By.name("dob")).click();
		
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
		
		driver.findElement(By.name("pan_no")).sendKeys(panno);
		driver.findElement(By.name("citizenship")).sendKeys(citizenship);
		driver.findElement(By.name("homeaddrs")).sendKeys(homeaddress);
		driver.findElement(By.name("officeaddrs")).sendKeys(officeaddress);
		WebElement ele1 = driver.findElement(By.name("state"));
		wutil.selectbyvisibletexts(ele1, state);
		
		 WebElement ele2 = driver.findElement(By.name("city"));
		wutil.selectbyvisibletexts(ele2,city );
		
		driver.findElement(By.name("pin")).sendKeys(pinno);
		driver.findElement(By.name("arealoc")).sendKeys(area);
		driver.findElement(By.name("acctype")).sendKeys(accountype);
		  
	
	   driver.findElement(By.name("submit")).click();
	   driver.findElement(By.name("cnfrm-submit")).click();
	  
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
		
	   //driver.switchTo().alert().accept();
	  
	  //staff login
	  
	   futil.readDataFromPropertyFile(URL);
	   
	   
	   //driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("staff_login-btn")).click();
		
		//approve application
		driver.findElement(By.name("apprvac")).click();
		driver.findElement(By.name("application_no")).sendKeys(applicationNumber);
		driver.findElement(By.name("search_application")).click();
		driver.findElement(By.name("approve_cust")).click();
		Thread.sleep(2000);
		//getting account number
		
		String accno = "";
		
		String text = driver.switchTo().alert().getText();
		for (int i=0;i<text.length();i++) {
			if(Character.isDigit(text.charAt(i))) {
				accno+=text.charAt(i);
		}
	}
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(accno);
	}
}

