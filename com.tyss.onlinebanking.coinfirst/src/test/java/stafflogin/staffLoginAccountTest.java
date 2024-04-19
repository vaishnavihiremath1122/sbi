package stafflogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staffLoginAccountTest {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			if(BROWSER.equalsIgnoreCase("chrome")){
				driver=new ChromeDriver();
				driver.get(URL);
				driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
				driver.findElement(By.name("password")).sendKeys(PASSWORD);
				driver.findElement(By.name("staff_login-btn")).click();
				
				//view active customr
				driver.findElement(By.name("viewdet")).click();
				System.out.println("customer account detials dispalyed");
				
				driver.findElement(By.name("home")).click();
				
				//delete customer
				driver.findElement(By.name("del_cust")).click();
				WebElement cstmraccnum = driver.findElement(By.name("Cust_ac_no"));
				WebElement cstmrid = driver.findElement(By.name("Cust_ac_Id"));
				WebElement reason = driver.findElement(By.name("reason"));
				
				
				//getting the data
				FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("delete_customer");
				int rowcount = sh.getLastRowNum();
				int cellcount = sh.getRow(0).getLastCellNum();
				
				
				//passing the values
				cstmraccnum.sendKeys(sh.getRow(0).getCell(1).getStringCellValue());
				cstmrid.sendKeys(sh.getRow(1).getCell(1).getStringCellValue());
				reason.sendKeys(sh.getRow(2).getCell(1).getStringCellValue());
				driver.findElement(By.name("delete")).click();
			}
	}
	}
}
