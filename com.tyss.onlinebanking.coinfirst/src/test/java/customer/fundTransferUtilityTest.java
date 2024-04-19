package customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.DataBaseUtility;
import com.genericUtility.ExcelUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.WebDriverUtility;
import com.genericUtility.fileUtility;
import com.onlinebanking.creditcoin.objectrepsitory.ApprpveAccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Creditcustomerpage;
import com.onlinebanking.creditcoin.objectrepsitory.CustLoginpage;
import com.onlinebanking.creditcoin.objectrepsitory.Fundtransferpage;
import com.onlinebanking.creditcoin.objectrepsitory.Homepage;
import com.onlinebanking.creditcoin.objectrepsitory.Openaccountpage;
import com.onlinebanking.creditcoin.objectrepsitory.Registerbankingpage;
import com.onlinebanking.creditcoin.objectrepsitory.Staffloginpage;

public class fundTransferUtilityTest extends BaseClass {
	
	@Test
	
	public void fundTransfer() throws IOException {
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
		
		
		Random r=new Random();
		int num = r.nextInt(400);
		//open account
		
		driver = new ChromeDriver();
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver, num);
		Homepage homepage=new Homepage(driver);
		CustLoginpage custLoginpage=new CustLoginpage(driver);
		
		Openaccountpage openaccountpage=new Openaccountpage(driver);
		ApprpveAccountpage apprpveaccount = new ApprpveAccountpage(driver);
		Staffloginpage staffloginpage=new Staffloginpage(driver);
		Creditcustomerpage creditcustomerpage=new Creditcustomerpage(driver);
		Registerbankingpage registerbankingpage=new Registerbankingpage(driver);
		Fundtransferpage fundtransferpage=new Fundtransferpage(driver);
		
		
		
		//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Properties p=new Properties();
		//p.load(fis);
		//String browser = p.getProperty("browser");
		//String url1 = p.getProperty("url1");
		//driver=new ChromeDriver();
		//driver.get(url1);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(URL1);
		homepage.enterfundtransbtn();
		//fundtransferpage.enterfundtransbtn();
		
		
		String custid = eutil.readDataFromExcel("fund_transfer",0,1);
		String pwd = eutil.readDataFromExcel("fund_transfer",1,1);
		
		custLoginpage.entercustidtxt(custid);
		custLoginpage.enterpwdtxt(pwd);
		custLoginpage.enterloginbtn();
		
		//driver.findElement(By.name("login-btn")).click();
		
		
		homepage.enterfundtransbtn();
		fundtransferpage.enteraddbeneficirybtn();
		
		//driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		//driver.findElement(By.name("customer_id")).sendKeys("1011865");
		//driver.findElement(By.name("password")).sendKeys("nick#123");
		//FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");

		//FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
	//	Workbook wb = WorkbookFactory.create(fis1);
	//	Sheet shn = wb.getSheet("beneficary_detila");
	//	int rowcount = shn.getLastRowNum();
	//	int cellcount = shn.getRow(0).getLastCellNum();
		
		
		//fundtransferpage.enterfundtransbtn();
		//driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
	
		//driver.findElement(By.name("add_beneficiary")).click();
		
		
		String beneficiaryname = eutil.readDataFromExcel("beneficary_detila", 0, 1);
		String beneficiaryaccno = eutil.readDataFromExcel("beneficary_detila", 1, 1);
		String ifscode = eutil.readDataFromExcel("beneficary_detila", 2, 1);
		
		
		//beneficiaryaccno=.sendKeys(shn.getRow(1).getCell(1).getStringCellValue());
		//ifscode=.sendKeys(shn.getRow(2).getCell(1).getStringCellValue());
		
		
		fundtransferpage.enterbenfnametxt(beneficiaryname);
		fundtransferpage.enterbenfaccnotxt(beneficiaryaccno);
		fundtransferpage.enterifsctxt(ifscode);
		//fundtransferpage.enterbenfacctypedd("saving", wutil);
		
		wutil.selectclassvalue("Saving", fundtransferpage.enterbenfacctypedd());
		fundtransferpage.enteraddbenfbtn();
	
		//wutil.acceptAlert(driver);
		//wutil.getText(driver);
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		
		
		fundtransferpage.enterfundtransbtn();
		fundtransferpage.enterviewbenfbtn();

		List<WebElement> acNos = driver.findElements(By.xpath("//tr/td[3]"));
		
		for(WebElement acNo: acNos)
		{
			if(acNos==acNo)
			{
				System.out.println("Beneficiary account is present");
			}
		}
		
		fundtransferpage.entergobackbtn();
		
		//driver.findElement(By.name("go_back")).click();
		//driver.close();
	
	}

}
