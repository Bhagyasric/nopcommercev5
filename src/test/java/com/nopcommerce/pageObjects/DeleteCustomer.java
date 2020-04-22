package com.nopcommerce.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer
{
	WebDriver ldriver;
	 public DeleteCustomer(WebDriver rdriver)
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(ldriver,this);
		 ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
	 }
	 @FindBy(id="customer-delete")
	 WebElement deletebtn;
	 
	 @FindBy(xpath="//button[@type=\"submit\"][@class=\"btn bg-red pull-right\"]")
	 WebElement deletebox;
	 
	 @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissable\"]")
	 WebElement text;
	 
	 
	 public void clickDltBtn()
	 {
		 deletebtn.click();
	 }
	 public void clickDltBox()
	 {
		 deletebox.click();
	 }
	 

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
}
