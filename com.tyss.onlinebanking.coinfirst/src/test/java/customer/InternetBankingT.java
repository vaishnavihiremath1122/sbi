package customer;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
import com.onlinebanking.creditcoin.objectrepsitory.Registerbankingpage;
import com.onlinebanking.creditcoin.objectrepsitory.Staffloginpage;
//@Listeners(com.genericUtility.ListenerImplementation.class)
public class InternetBankingT extends BaseClass {
	
	@Test
	
	public  void registerCustoAndGetCustId() throws IOException, AWTException, InterruptedException {

		WebDriverUtility wutil=new WebDriverUtility();
		ExcelUtility eutil=new ExcelUtility();
		fileUtility futil=new fileUtility();
		DataBaseUtility dbutil=new DataBaseUtility();
		JavaUtility jutil=new JavaUtility();
	     
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL1 = futil.readDataFromPropertyFile("url1");
		WebDriver driver = new ChromeDriver();
		
		Random r=new Random();
		int num = r.nextInt(400);
		driver.get(URL1);
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver,10);
		
	
		Homepage homepage=new Homepage(driver);
		Openaccountpage openaccountpage=new Openaccountpage(driver);
		ApprpveAccountpage apprpveaccount = new ApprpveAccountpage(driver);
		Staffloginpage staffloginpage=new Staffloginpage(driver);
		Creditcustomerpage creditcustomerpage=new Creditcustomerpage(driver);
		Registerbankingpage registerbankingpage=new Registerbankingpage(driver);
		
		
		//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Properties p=new Properties();
		//p.load(fis);
		//String browser = p.getProperty("browser");
		//String url1 = p.getProperty("url1");
		//driver=new ChromeDriver();
		//driver.get(url1);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Clicking on Internet Banking to register for internet banking
		//WebElement eb = driver.findElement(By.id("ebanking"));
		//homepage.ebankingbtn();
		//homepage.enterregisterbtn();
		WebElement eb = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		WebElement element= driver.findElement(By.xpath("//li[text()='Register']"));
		
		   Thread.sleep(2000);
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView(true)", eb);
		    Actions action =new Actions(driver);
		    action.moveToElement(eb).perform();
		    element.click();
		    //Validating the  Internet banking registration page
		    
		    if(driver.getTitle().contains("Internet Banking Registration")) {
			System.out.println("Internet Banking Registration page is displayed");
			
			//homepage.ebankingbtn();
			//homepage.enterregisterbtn();
			//getting data from excel
			
			String acholdername = eutil.readDataFromExcel("internetbanking", 0, 1);
			String accnum = eutil.readDataFromExcel("internetbanking", 1, 1);
			String dbtcrdnum = eutil.readDataFromExcel("internetbanking", 2, 1);
			String dbtpin = eutil.readDataFromExcel("internetbanking", 3, 1);
			String mbno = eutil.readDataFromExcel("internetbanking", 4, 1);
			String pan = eutil.readDataFromExcel("internetbanking", 5, 1);
			String trasctin = eutil.readDataFromExcel("internetbanking", 6, 1);
			String pwd = eutil.readDataFromExcel("internetbanking", 7, 1);
			String cnfpwd = eutil.readDataFromExcel("internetbanking", 8, 1);
		
			
			registerbankingpage.enteraccholdrnametxt(acholdername);
			registerbankingpage.enteraccnotxt(accnum);
			registerbankingpage.enterdbtnotxt(dbtcrdnum);
			registerbankingpage.enterdbtpintxt(dbtpin);
			registerbankingpage.entermbnotxt(mbno);
			
			
			//Assert.fail();
			
			registerbankingpage.enterpantxt(pan);
			registerbankingpage.enterdobtxt();
			registerbankingpage.enterlasttransctiontxt(trasctin);
			registerbankingpage.enterpwdtxt(pwd);
			registerbankingpage.enterconpwdtxt(cnfpwd);
			registerbankingpage.entersubmitbtn();
			
			//Assert.fail();
			
			//WebElement acholdername = driver.findElement(By.name("holder_name"));
			//WebElement accnum = driver.findElement(By.name("accnum"));
			//WebElement dbtcrdnum = driver.findElement(By.name("dbtcard"));
			//WebElement dbtpin = driver.findElement(By.name("dbtpin"));
			//WebElement mbno = driver.findElement(By.name("mobile"));
	        //WebElement pan = driver.findElement(By.name("pan_no"));
			//WebElement dob = driver.findElement(By.name("dob"));
			//dob.click();
			//WebElement trasctin = driver.findElement(By.name("last_trans"));
			//WebElement pwd = driver.findElement(By.name("password"));
			//WebElement cnfpwd = driver.findElement(By.name("cnfrm_password"));
			//driver.findElement(By.name("submit")).click();
			
		//	FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
		//	Workbook wb = WorkbookFactory.create(fis1);
		//	Sheet shn = wb.getSheet("internetbanking");
		//	int rowcount = shn.getLastRowNum();
		//	int cellcount = shn.getRow(0).getLastCellNum();
			
			
			driver.findElement(By.name("submit")).click();
			System.out.println("submitted");
			
			driver.switchTo().alert().accept();
			}
		}
}