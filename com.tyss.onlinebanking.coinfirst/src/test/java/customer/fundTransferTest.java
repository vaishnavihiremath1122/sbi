package customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fundTransferTest {
		public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url1 = p.getProperty("url1");
		driver=new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		driver.findElement(By.name("customer_id")).sendKeys("1011865");
		driver.findElement(By.name("password")).sendKeys("nick#123");
		driver.findElement(By.name("login-btn")).click();
		
		//FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");

		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet shn = wb.getSheet("beneficary_detila");
		int rowcount = shn.getLastRowNum();
		int cellcount = shn.getRow(0).getLastCellNum();
		
		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		driver.findElement(By.name("add_beneficiary")).click();
		
		WebElement beneficiaryname = driver.findElement(By.name("beneficiary_name"));
		beneficiaryname.sendKeys(shn.getRow(0).getCell(1).getStringCellValue());
		
		WebElement beneficiaryaccno = driver.findElement(By.name("beneficiary_acno"));
		beneficiaryaccno.sendKeys(shn.getRow(1).getCell(1).getStringCellValue());
		
		
		WebElement ifscode = driver.findElement(By.name("Ifsc_code"));
		ifscode.sendKeys(shn.getRow(2).getCell(1).getStringCellValue());
		
		WebElement bnf = driver.findElement(By.name("beneficiary_acc_type"));
		
		Select s = new Select(bnf);
		s.selectByVisibleText("Saving");
		
		driver.findElement(By.name("add_beneficiary_btn")).click();
		
	    Alert a = driver.switchTo().alert();
	    String text = a.getText();
	    a.accept();
	 
		driver.findElement(By.xpath("//li[.='Fund Transfer']")).click();
		
		
		driver.findElement(By.name("view_beneficiary")).click();

		List<WebElement> acNos = driver.findElements(By.xpath("//tr/td[3]"));
		System.out.println("++++++++++++");
		for(WebElement acNo: acNos)
		{
			if(acNos==acNo)
			{
				System.out.println("Beneficiary account is present");
			}
		}
		
		driver.findElement(By.name("go_back")).click();
		driver.close();
	 }
}
