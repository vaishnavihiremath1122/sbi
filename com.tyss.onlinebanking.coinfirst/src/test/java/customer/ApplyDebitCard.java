package customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.DataBaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.genericUtility.fileUtility;
import com.onlinebanking.creditcoin.objectrepsitory.Applydebitcardpage;
import com.onlinebanking.creditcoin.objectrepsitory.ApprpveAccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Homepage;
import com.onlinebanking.creditcoin.objectrepsitory.Openaccountpage;

public class ApplyDebitCard {
	
	public static WebDriver driver;
	
	public static String[] fetchDebitAndPin(String text) {

		String[] lines = text.split("\\r?\\n");
		System.out.println(Arrays.toString(lines));
		// Search for the line containing the application number

		String debitCardNum = "";
		String pin = "";
		String[] parts = null;
		
		for (String line : lines) {

			if (line.contains("Your Debit Card No is : ")) {
				// Split the line to get the application number
				parts = line.trim().split(" ");

				for (String part : parts) {
					if (isNumeric(part)) {
						if (debitCardNum.isEmpty()) {
							debitCardNum = part;
						} else {
							pin = part;
							break;
						}
					}
				}

				// Break the loop once the application number is found
			}
		}
		String[] arr= {debitCardNum,pin};
		return arr;
}
	public static boolean isNumeric(String str) {

		for (int i = 0; i < str.length(); i++) {

			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	@Test(groups="smoke")
	
	
	public void applyDebitCard()throws IOException, AWTException, InterruptedException{
		
		
		WebDriverUtility wutil=new WebDriverUtility();
		ExcelUtility eutil=new ExcelUtility();
		fileUtility futil=new fileUtility();
		DataBaseUtility dbutil=new DataBaseUtility();
		JavaUtility jutil=new JavaUtility();
		//WebDriver driver=null;
		
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL1 = futil.readDataFromPropertyFile("url1");
		
		driver=new ChromeDriver();
		driver.get(URL1);
		
		Homepage homepage=new Homepage(driver);
		Openaccountpage openaccountpage=new Openaccountpage(driver);
		ApprpveAccountpage apprpveaccount = new ApprpveAccountpage(driver);
		Applydebitcardpage applydebitcardpage=new Applydebitcardpage(driver);
	
	   
	   String achn = eutil.readDataFromExcel("debitcard", 0, 1);
	   String pan = eutil.readDataFromExcel("debitcard", 1, 1);
	   String mb = eutil.readDataFromExcel("debitcard", 2, 1);
	   String acn= eutil.readDataFromExcel("debitcard", 3, 1);
	  
	  
	   //passing methodname with ref class
	   
	   	homepage.enterapplydebitbtn();
	   	Thread.sleep(2000);
	   	applydebitcardpage.enteraccholdertxt(achn);
		applydebitcardpage.enterdobtxt();
		applydebitcardpage.enterpantxt(pan);
		applydebitcardpage.entermbltxt(mb);
		applydebitcardpage.enteraccnotxt(acn);
		
		applydebitcardpage.enterdbtcrdbtn();
		Thread.sleep(2000);
	    String text = driver.switchTo().alert().getText();
	    Thread.sleep(2000);
	    String[] arr=fetchDebitAndPin(text);
		   String debitCardNum=	arr[0];
		   String debitpin=arr[1];
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			System.out.println(debitpin);
		   }
	}

		
