package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class Fundtransferpage {
		@FindBy(xpath="//li[text()='Fund Transfer']")
		private WebElement fundtransbtn;
		
		@FindBy(name="add_beneficiary")
		private WebElement addbeneficirybtn;
		
		@FindBy(name="beneficiary_name")
		private WebElement benfnametxt;
		
		@FindBy(name="beneficiary_acno")
		private WebElement benfaccnotxt;
		
		@FindBy(name="Ifsc_code")
		private WebElement ifsctxt;
		
		@FindBy(name="beneficiary_acc_type")
		private WebElement benfacctypedd;
		
		@FindBy(name="add_beneficiary_btn")
		private WebElement addbenfbtn;
		
		
		@FindBy(name="view_beneficiary")
		private WebElement viewbenfbtn;
		
		@FindBy(name="beneficiary")
		private WebElement benftypedd;
		
		@FindBy(name="trnsf_amount")
		private WebElement trnsamttxt;
		
		@FindBy(name="trnsf_remark")
		private WebElement remarktex;
		
		@FindBy(name="fnd_trns_btn")
		private WebElement sendbtn;
		
		
		@FindBy(name="go_back")
		private WebElement gobackbtn;
		
		
		
		//constur
		
		public Fundtransferpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//methods
		
		public void enterfundtransbtn() {
			fundtransbtn.click();
		}
		
		public void enteraddbeneficirybtn() {
			addbeneficirybtn.click();
		}
		
		public void enterbenfnametxt(String beneficiaryname) {
			benfnametxt.sendKeys(beneficiaryname);
		}
		
		public void enterbenfaccnotxt(String beneficiaryaccno) {
			benfaccnotxt.sendKeys(beneficiaryaccno);
		}
		
		public void enterifsctxt(String ifscode) {
			ifsctxt.sendKeys(ifscode);
		}
		
		public WebElement enterbenfacctypedd() {
			return benfacctypedd;
		}
		
		
		public void enteraddbenfbtn() {
			addbenfbtn.click();
		}
		
		public void enterviewbenfbtn() {
			viewbenfbtn.click();
		}
		
		public void entertrnsamttxt() {
			trnsamttxt.sendKeys(null);
		}
		
		public void entergobackbtn() {
			gobackbtn.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
