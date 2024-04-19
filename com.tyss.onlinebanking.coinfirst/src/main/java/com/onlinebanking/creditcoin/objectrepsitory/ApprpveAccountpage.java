package com.onlinebanking.creditcoin.objectrepsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprpveAccountpage{

	
	@FindBy(name="apprvac")
	private WebElement apprvacbtn;
	
	@FindBy(name="application_no")
	private WebElement application_notxt;
	
	@FindBy(name="search_application")
	private WebElement searchapplctionbtn;
	
	@FindBy(name="approve_cust")
	private WebElement aprovebtn;
	
	
	//constror
	
	public ApprpveAccountpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//method
	
	public void enterapprvacbtn() {
		apprvacbtn.click();
	}
	
	public void enterapplicationtxt(String applictionno) {
		application_notxt.sendKeys(applictionno);
	}
	
	public void entersearchbtn() {
		searchapplctionbtn.click();
	}
	
	public void enterapprove() {
		aprovebtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
