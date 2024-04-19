package com.onlinebanking.creditcoin.objectrepsitory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class Registerbankingpage {
		@FindBy(name="holder_name")
		private WebElement accholdrnametxt;
		
		@FindBy(name="accnum")
		private WebElement accnotxt;
		
		@FindBy(name="dbtcard")
		private WebElement dbtnotxt;
		
		@FindBy(name="dbtpin")
		private WebElement dbtpintxt;
		
		
		@FindBy(name="mobile")
		private WebElement mbnotxt;
		
		@FindBy(name="pan_no")
		private WebElement pantxt;
		
		@FindBy(name="dob")
		private WebElement dobtxt;
		
		@FindBy(name="last_trans")
		private WebElement lasttransctiontxt;
		
		@FindBy(name="password")
		private WebElement pwdtxt;
		
		@FindBy(name="cnfrm_password")
		private WebElement conpwdtxt;
		
		@FindBy(name="submit")
		private WebElement submitbtn;
		
		
		//constor
		
		public Registerbankingpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//methods
		
		public void enteraccholdrnametxt(String acholdername) {
			accholdrnametxt.sendKeys(acholdername);
		}
		
		public void enteraccnotxt(String acn) {
			accnotxt.sendKeys(acn);
		}
		
		public void enterdbtnotxt(String dbtcrdnum) {
			dbtnotxt.sendKeys(dbtcrdnum);
		}
		
		public void enterdbtpintxt(String dbtpin) {
			dbtpintxt.sendKeys(dbtpin);
		}
		
		public void entermbnotxt(String mbno) {
			mbnotxt.sendKeys(mbno);
		}
		
		public void enterpantxt(String pan) {
			pantxt.sendKeys(pan);
		}
		
		public void enterdobtxt() throws AWTException {
			dobtxt.click();
			Robot rt=new Robot();
			rt.keyPress(KeyEvent.VK_1);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_0);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_0);
			rt.keyPress(KeyEvent.VK_2);
			rt.keyPress(KeyEvent.VK_2);
		}
		
		public void enterlasttransctiontxt(String trasctin) {
			lasttransctiontxt.sendKeys(trasctin);
		}
			
		public void enterpwdtxt(String pwd) {
			pwdtxt.sendKeys(pwd);
		}
		
		public void enterconpwdtxt(String cnfpwd) {
			conpwdtxt.sendKeys(cnfpwd);
		}
		
		public void entersubmitbtn() {
			submitbtn.click();
		}
		
		
		
		
		
		
		
		
		
		
		
}
