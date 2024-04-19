package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deletecustomerpage {
		@FindBy(name="Cust_ac_no")
		private WebElement custaccnotxt;
		
		@FindBy(name="Cust_ac_Id")
		private WebElement custaccidtxt;
		
		@FindBy(name="reason")
		private WebElement reasontxt;
		
		@FindBy(name="delete")
		private WebElement deletebtn;
		
		
		//constor
		public Deletecustomerpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//methods
		
		public void entercustaccnotxt(String cstmraccnum) {
			custaccnotxt.sendKeys(cstmraccnum);
		}
		
		public void entercustaccidtxt(String cstmrid) {
			custaccidtxt.sendKeys(cstmrid);
		}
		
		public void enterreasontxt(String reason) {
			reasontxt.sendKeys(reason);
		}
		
		public void enterdeletebtn() {
			deletebtn.click();
		}
}
