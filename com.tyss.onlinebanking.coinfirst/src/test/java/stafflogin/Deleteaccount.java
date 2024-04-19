package stafflogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import com.onlinebanking.creditcoin.objectrepsitory.Deletecustomerpage;
import com.onlinebanking.creditcoin.objectrepsitory.Homepage;
import com.onlinebanking.creditcoin.objectrepsitory.Openaccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Staffloginpage;

public class Deleteaccount extends BaseClass {
			
	@Test
	
	public void deleteCustomer() throws IOException {
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
		String URL1 = futil.readDataFromPropertyFile("url1");
		
		
		//creating object of class
		Random r=new Random();
		int num = r.nextInt(400);

		driver = new ChromeDriver();
		
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver, num);
		
		
		Homepage homepage=new Homepage(driver);
		Openaccountpage openaccountpage=new Openaccountpage(driver);
		ApprpveAccountpage apprpveaccount = new ApprpveAccountpage(driver);
		Staffloginpage staffloginpage=new Staffloginpage(driver);
		Deletecustomerpage deletecustomerpage=new Deletecustomerpage(driver);
		
		//open account
	
		driver.get(URL);
		homepage.stafflink(URL);
		homepage.staffidtxtf(USERNAME);
		homepage.passwordtxtf(PASSWORD);
		homepage.loginbtn();
		//view active customr
		staffloginpage.enterviewdetbtn();
		//	driver.findElement(By.name("viewdet")).click();
		System.out.println("customer account detials dispalyed");
				
		staffloginpage.enterhomebtn();		
		//driver.findElement(By.name("home")).click();
		String cstmraccnum= eutil.readDataFromExcel("delete_customer", 0, 1);
		String cstmrid= eutil.readDataFromExcel("delete_customer", 1, 1);
		String 	reason= eutil.readDataFromExcel("delete_customer", 2, 1);
				//delete customer
				staffloginpage.enterdltcustbtn();
				//driver.findElement(By.name("del_cust")).click();
				deletecustomerpage.entercustaccnotxt(cstmraccnum);
				deletecustomerpage.entercustaccidtxt(cstmrid);
				deletecustomerpage.enterreasontxt(reason);
				deletecustomerpage.enterdeletebtn();
				
				//WebElement cstmraccnum = driver.findElement(By.name("Cust_ac_no"));
				//WebElement cstmrid = driver.findElement(By.name("Cust_ac_Id"));
				//WebElement reason = driver.findElement(By.name("reason"));
				//getting the data
				//FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
				//Workbook wb = WorkbookFactory.create(fis1);
				//Sheet sh = wb.getSheet("delete_customer");
				//int rowcount = sh.getLastRowNum();
				//int cellcount = sh.getRow(0).getLastCellNum();
				//passing the value
				//driver.findElement(By.name("delete")).click();
		
	}
}
