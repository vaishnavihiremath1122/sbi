package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustLoginpage {
		@FindBy(name="customer_id")
		private WebElement custidtxt;
		
		@FindBy(name="password")
		private WebElement pwdtxt;
		
		@FindBy(name="login-btn")
		private WebElement loginbtn;
		
		public CustLoginpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		

		public void entercustidtxt(String custid) {
			custidtxt.sendKeys(custid);
		}
		public  void enterpwdtxt(String pwd) {
			pwdtxt.sendKeys(pwd);
		}
		
		public void enterloginbtn() {
			loginbtn.click();
		}
			
}
