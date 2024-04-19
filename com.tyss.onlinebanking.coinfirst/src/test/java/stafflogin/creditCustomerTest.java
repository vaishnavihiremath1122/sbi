package stafflogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class creditCustomerTest {


	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
	
		driver = new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("staff_login-btn")).click();
		
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		driver.findElement(By.name("credit_cust_ac")).click();

		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet shn = wb.getSheet("credit_customer");
		int rowcount = shn.getLastRowNum();
		int cellcount = shn.getRow(0).getLastCellNum();
		
		//crediting amount
		driver.findElement(By.name("customer_account_no")).sendKeys(shn.getRow(0).getCell(1).getStringCellValue());
		driver.findElement(By.name("credit_amount")).sendKeys(shn.getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.name("credit_btn")).click();

		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();

		driver.findElement(By.name("logout_btn")).click();
		
		driver.close();



	}

}
