package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	
		@FindBy (xpath="//a[text()='Home']")
		private WebElement homeblink;
		 
		@FindBy (xpath="//a[text()='Staff Login']")
		private WebElement stafflink;
		
		@FindBy (xpath="//input[@name='staff_id']")
		private WebElement staffidtxtf;
		
		@FindBy (xpath="//input[@name='password']")
		private WebElement passwordtxtf;
		
		@FindBy (xpath="//input[@name='staff_login-btn']")
		private WebElement loginbtn;
		
		@FindBy(xpath="//li[text()='Apply Debit Card']")
		private WebElement applydebitbtn;
		
		
		@FindBy(id="ebanking")
		private WebElement ebankingbtn;
		
		@FindBy(xpath="//li[text()='Register']")
		private WebElement registerbtn;
		
		@FindBy(xpath="//li[text()='Fund Transfer']")
		private WebElement fundtranbtn;
		
		//Constructor
		
		public Homepage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//methods
		
		public void stafflink(String uRL) {
			stafflink.click();
		}
		
		public void staffidtxtf(String stafftxt ) {
			staffidtxtf.sendKeys(stafftxt);
		}
		
		public void passwordtxtf(String pwdtxt) {
			passwordtxtf.sendKeys(pwdtxt);
		}
		
		public void loginbtn() {
			loginbtn.click();
		}
		
		public void enterapplydebitbtn() {
			applydebitbtn.click();
		}
		
		public void ebankingbtn() {
			ebankingbtn.click();
		}
		
		public void enterregisterbtn() {
			registerbtn.click();
		}
		
		public void enterfundtransbtn() {
			fundtranbtn.click();
		}
		
	}

