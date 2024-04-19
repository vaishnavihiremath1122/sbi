package stafflogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.DataBaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.genericUtility.fileUtility;
import com.onlinebanking.creditcoin.objectrepsitory.ApprpveAccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Creditcustomerpage;
import com.onlinebanking.creditcoin.objectrepsitory.Homepage;
import com.onlinebanking.creditcoin.objectrepsitory.Openaccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Staffloginpage;

public class CreditCustomer extends BaseClass{
	

	@Test
	public void creditAmtTOcustAcc() throws EncryptedDocumentException, IOException {
		
		//WebDriverUtility wutil=new WebDriverUtility();
		//ExcelUtility eutil=new ExcelUtility();
		//fileUtility futil=new fileUtility();
		//DataBaseUtility dbutil=new DataBaseUtility();
		//JavaUtility jutil=new JavaUtility();
		//WebDriver driver=null;
		
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL1 = futil.readDataFromPropertyFile("url1");
		
		//driver = new ChromeDriver();
		//wutil.maximizeWindow(driver);
		//wutil.waitForPageLoad(driver, num);
		
		Homepage homepage=new Homepage(driver);
		Openaccountpage openaccountpage=new Openaccountpage(driver);
		ApprpveAccountpage apprpveaccount = new ApprpveAccountpage(driver);
		Staffloginpage staffloginpage=new Staffloginpage(driver);
		Creditcustomerpage creditcustomerpage=new Creditcustomerpage(driver);
		
		driver.get(URL);
		homepage.stafflink(URL);
		homepage.staffidtxtf(USERNAME);
		homepage.passwordtxtf(PASSWORD);
		homepage.loginbtn();
		
		
		//driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		//driver.findElement(By.name("password")).sendKeys(PASSWORD);
		//driver.findElement(By.name("staff_login-btn")).click();
		
		//driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		
		staffloginpage.entercreditbtn();
		
		//driver.findElement(By.name("credit_cust_ac")).click();

		//FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
		//Workbook wb = WorkbookFactory.create(fis1);
		//Sheet shn = wb.getSheet("credit_customer");
		//int rowcount = shn.getLastRowNum();
		//int cellcount = shn.getRow(0).getLastCellNum();
		
		//crediting amount
		
		
		String acno1 = eutil.readDataFromExcel("credit_customer", 0, 1);
		String amount = eutil.readDataFromExcel("credit_customer", 0, 1);
		
		creditcustomerpage.entercstmracctext(acno1);
		creditcustomerpage.entercrdtamttxt(amount);
		creditcustomerpage.entercreditbtn();
		
		
		//WebElement acno = driver.findElement(By.name("customer_account_no"));
		//WebElement amount1= driver.findElement(By.name("credit_amount"));
		//driver.findElement(By.name("credit_btn")).click();

		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		
		
		creditcustomerpage.enterlogoutbtn();
		//driver.findElement(By.name("logout_btn")).click();
		
		driver.close();



	}

	}


