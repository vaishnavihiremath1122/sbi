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

public class applyDebitCardTest {
	
	
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
	
		public static void main(String[] args) throws IOException, AWTException, InterruptedException{
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties p=new Properties();
			p.load(fis);
			String browser = p.getProperty("browser");
			String url1 = p.getProperty("url1");
			driver=new ChromeDriver();
			driver.get(url1);
			driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
			WebElement	achn = driver.findElement(By.name("holder_name"));
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
			WebElement pan = driver.findElement(By.name("pan"));
			WebElement mb = driver.findElement(By.name("mob"));
			WebElement acn = driver.findElement(By.name("acc_no"));
			
			
			FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Testscriptdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet shn = wb.getSheet("debitcard");
			int rowcount = shn.getLastRowNum();
			int cellcount = shn.getRow(0).getLastCellNum();
			
		
			ArrayList<String> list = new ArrayList<>();
			System.out.println(rowcount);
			System.
			out.println(cellcount);
			
		   for(int i=0;i<=rowcount;i++) {
			   String value=shn.getRow(i).getCell(1).getStringCellValue();
			   list.add(value);
		   }
		   
		   Thread.sleep(2000);
		   
		   achn.sendKeys(list.get(0));
		   System.out.println(list);
		   pan.sendKeys(list.get(1));
		   System.out.println(list);
		   mb.sendKeys(list.get(2));
		   acn.sendKeys(list.get(3));
		   
		   driver.findElement(By.name("dbt_crd_submit")).click();
		
		   //handling popup
		
		 String text = driver.switchTo().alert().getText();
			String[] arr=fetchDebitAndPin(text);
		   String debitCardNum=	arr[0];
		   String debitpin=arr[1];
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			System.out.println(debitpin);
		   
			}
		}

			
			