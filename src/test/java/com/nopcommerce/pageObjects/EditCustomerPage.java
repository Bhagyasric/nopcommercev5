package com.nopcommerce.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage 
{
	WebDriver ldriver;
	 public EditCustomerPage(WebDriver rdriver)
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(ldriver,this);
		 ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
	 }
	 
	 @FindBy(xpath="//a[@class=\"btn btn-default\"]")
	 WebElement editBtn;
	 @FindBy(id="FirstName")
	 WebElement firstName;
	 @FindBy(xpath="//button[@name=\"save\"]")
	 WebElement saveBtn;
	 
	 @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissable\"]")
	 WebElement text;
	  
	 public boolean msg()
	 {
		boolean flag=false;
		boolean actvalue= text.isDisplayed();
		if(actvalue==true)
		{
			flag=true;
		}
		else
		{
			flag=false;
		}
		return flag;
		
	 }
	 
	 
	 public void clickEdit()
	 {
		 editBtn.click();
	 }
	 public void setfrstN() 
	 {
		 firstName.clear();
	 }
	 public void setfrstN(String fn) 
	 {
		 firstName.sendKeys(fn);
	 }
		
	 public void clickSave()
	 {
		 saveBtn.click();
	 }
	 
	 
	 
	
	 
	 
	 
	 
}
