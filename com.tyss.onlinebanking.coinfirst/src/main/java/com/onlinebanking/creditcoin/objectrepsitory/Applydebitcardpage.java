package com.onlinebanking.creditcoin.objectrepsitory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Applydebitcardpage {
		@FindBy(name="holder_name")
		private WebElement accholdertxt;
		
		@FindBy(name="dob")
		private WebElement dobtxt;
		
		@FindBy(name="pan")
		private WebElement pantxt;
		
		@FindBy(name="mob")
		private WebElement mbltxt;
		
		@FindBy (name="acc_no")
		private WebElement accnotxt;
		
		@FindBy(name="dbt_crd_submit")
		private WebElement dbtcrdbtn;
		
		
		//constor
		public Applydebitcardpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//methods
		
		public void enteraccholdertxt(String achn) {
			accholdertxt.sendKeys(achn);
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
		
		public void enterpantxt(String panno) {
			pantxt.sendKeys(panno);
		}
		
		public void entermbltxt(String mbno) {
			mbltxt.sendKeys(mbno);
		}
		
		public void enteraccnotxt(String accno) {
			accnotxt.sendKeys(accno);
		}
		
		
		public void enterdbtcrdbtn() {
			dbtcrdbtn.click();
		}
		
		
		
	}
