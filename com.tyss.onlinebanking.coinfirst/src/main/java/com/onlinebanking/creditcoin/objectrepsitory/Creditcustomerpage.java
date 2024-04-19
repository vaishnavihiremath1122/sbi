package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creditcustomerpage {
		@FindBy (name="customer_account_no")
		private WebElement cstmracctext;
		
		@FindBy(name="credit_amount")
		private WebElement crdtamttxt;
		
		@FindBy(name="credit_btn")
		private WebElement creditbtn;
		
		@FindBy(name="logout_btn")
		private WebElement logoutbtn;
		
		//constor
		
		public Creditcustomerpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//method
		
		public void entercstmracctext(String acno1) {
			cstmracctext.sendKeys(acno1);;
		}
		
		public void entercrdtamttxt(String amount) {
			crdtamttxt.sendKeys(amount);
		}
		
		public void entercreditbtn() {
			creditbtn.click();
		}	
			
		public void enterlogoutbtn() {
			logoutbtn.click();
		}
		
	}
		

