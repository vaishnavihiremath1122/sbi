package customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class internetBankingTest {

	
		public static WebDriver driver;
		@Test
		
		public static void main(String[] args) throws IOException, AWTException, InterruptedException {
	
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url1 = p.getProperty("url1");
		driver=new ChromeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Clicking on Internet Banking to register for internet banking
		//WebElement eb = driver.findElement(By.id("ebanking"));
		
		
		 WebElement eb=driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		    WebElement element= driver.findElement(By.xpath("//li[text()='Register']"));
		   
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView(true)", eb);
		    Actions action =new Actions(driver);
		    action.moveToElement(eb).perform();
		    element.click();
		    //Validating the  Internet banking registration page
		    if(driver.getTitle().contains("Internet Banking Registration")) {
			System.out.println("Internet Banking Registration page is displayed");
			
			WebElement acholdername = driver.findElement(By.name("holder_name"));
			WebElement accnum = driver.findElement(By.name("accnum"));
			WebElement dbtcrdnum = driver.findElement(By.name("dbtcard"));
			WebElement dbtpin = driver.findElement(By.name("dbtpin"));
			WebElement mbno = driver.findElement(By.name("mobile"));
	
			WebElement pan = driver.findElement(By.name("pan_no"));
			
			
			WebElement dob = driver.findElement(By.name("dob"));
			dob.click();
			Robot rt=new Robot();
			rt.keyPress(KeyEvent.VK_1);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_0);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_0);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_2);
			
			
			WebElement trasctin = driver.findElement(By.name("last_trans"));
			WebElement pwd = driver.findElement(By.name("password"));
			WebElement cnfpwd = driver.findElement(By.name("cnfrm_password"));
			
			driver.findElement(By.name("submit")).click();
			
			FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet shn = wb.getSheet("internetbanking");
			int rowcount = shn.getLastRowNum();
			int cellcount = shn.getRow(0).getLastCellNum();
			
			//getting data from excel
			acholdername.sendKeys(shn.getRow(0).getCell(1).getStringCellValue());
			
			accnum .sendKeys(shn.getRow(1).getCell(1).getStringCellValue());
		
			dbtcrdnum.sendKeys(shn.getRow(2).getCell(1).getStringCellValue());
		
			dbtpin.sendKeys(shn.getRow(3).getCell(1).getStringCellValue());
		
			mbno.sendKeys(shn.getRow(4).getCell(1).getStringCellValue());
	
			pan.sendKeys(shn.getRow(5).getCell(1).getStringCellValue());
			
			trasctin.sendKeys(shn.getRow(6).getCell(1).getStringCellValue());
		
			pwd.sendKeys(shn.getRow(7).getCell(1).getStringCellValue());
	
			cnfpwd.sendKeys(shn.getRow(8).getCell(1).getStringCellValue());
		
			driver.findElement(By.name("submit")).click();
			
			System.out.println("submitted");
			}
		}
}
