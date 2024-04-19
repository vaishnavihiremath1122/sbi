package com.onlinebanking.creditcoin.objectrepsitory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class Openaccountpage {
		@FindBy(xpath="//li[text()='Open Account']")
		private WebElement openaccbtn;
		
		@FindBy(xpath="//input[@placeholder='Name']")
		private WebElement nametxt;
		
		@FindBy(xpath="//select[@name='gender']")
		private WebElement gendertxt;
		
		@FindBy(xpath="//input[@placeholder='Mobile no']")
		private WebElement mblnotxt;
		
		@FindBy(xpath="//input[@placeholder='Email id']")
		private WebElement emailtxt;
		
		@FindBy(name="landline")
		private WebElement landlinetxt;
		
		@FindBy(name="dob")
		private WebElement dobtxt;
		
		@FindBy(name="pan_no")
		private WebElement pannotxt;
		
		@FindBy(name="citizenship")
		private WebElement citizenshiptxt;
		
		@FindBy(name="homeaddrs")
		private WebElement homeadrestxt;
		
		@FindBy(name="officeaddrs")
		private WebElement officeaddtxt;
		
		@FindBy(name="state")
		private WebElement statedd;
		
		@FindBy(name="city")
		private WebElement citydd;
		
		@FindBy(name="pin")
		private WebElement pintxt;
		
		@FindBy(name="arealoc")
		private WebElement arealoctxt;
		
		@FindBy(name="acctype")
		private WebElement acctypedd;
		
		@FindBy(name="submit")
		private WebElement submitbtn;
		
		
		@FindBy(name="cnfrm-submit")
		private WebElement cnfrmbtn;
		
		//constructor
		
		public Openaccountpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//methods
		
		public void enteropenaccbtn() {
			openaccbtn.click();;
		}
		public void enternametxt(String name) {
			nametxt.sendKeys(name);
		}
			
		public void enterGendertxt(String gender,WebDriverUtility wutil) {
			wutil.selectByVisibleText(gender, gendertxt);
		}
		
		public void entermblnotxt(String mbno) {
			mblnotxt.sendKeys(mbno);
		}
		
		public void enteremailtxt(String email) {
			emailtxt.sendKeys(email);
		}
		
		public void enterlandlinetxt(String landlineno) {
			landlinetxt.sendKeys(landlineno);
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
		
		public void enterpannotxt(String panno) {
			pannotxt.sendKeys(panno);
		}
		
		public void entercitizenshiptxt(String citizenship)
		{
			citizenshiptxt.sendKeys(citizenship);
		}
		
		public void enterhomeadrestxt(String homeaddress) {
			homeadrestxt.sendKeys(homeaddress);
		}
		
		public void enterofficeaddtxt(String officeaddress) {
			officeaddtxt.sendKeys(officeaddress);
		}
		
		public void enterstatedd(String state) {
			statedd.sendKeys(state);
		}
		
		public void entercitydd(String city) {
			citydd.sendKeys(city);
		}
		
		public void enterpintxt(String pinno) {
			pintxt.sendKeys(pinno);
		}
		
		public void enterarealoctxt(String area) {
			arealoctxt.sendKeys(area);
		}
		
		public void acctypedd(String accountype) {
			acctypedd.sendKeys(accountype);
		}
		
		public void submitbtn(){
			submitbtn.click();
		}
		
		public void cnfrmbtn() {
			cnfrmbtn.click();
		}
		
		
}
