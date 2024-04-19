package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staffloginpage {
		@FindBy(name="credit_cust_ac")
		private WebElement creditbtn;
		
		@FindBy(name="viewdet")
		private WebElement viewdetbtn;
		
		@FindBy(name="view_cust_by_ac")
		private WebElement custbtaccnobtn;
		
		@FindBy(name="del_cust")
		private WebElement dltcustbtn;
		
		@FindBy(name="home")
		private WebElement homebtn;
		
		//constur
		
		public Staffloginpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//methods
		
		public void entercreditbtn() {
			creditbtn.click();
		}
		
		public void enterviewdetbtn() {
			viewdetbtn.click();
		}
		
		public void entercustbtaccnobtn() {
			custbtaccnobtn.click();
		}
		
		public void enterdltcustbtn() {
			dltcustbtn.click();
		}
		
		public void enterhomebtn() {
			homebtn.click();
		}

		public void getData(String username, String pwd) {
			// TODO Auto-generated method stub
			
		}
		
}
