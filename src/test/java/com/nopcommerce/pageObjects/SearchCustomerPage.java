package com.nopcommerce.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage 
{
 WebDriver ldriver;
 public SearchCustomerPage(WebDriver rdriver)
 {
	 ldriver=rdriver;
	 PageFactory.initElements(ldriver,this);
	 ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
 }
 
 @FindBy (how = How.ID, using="SearchEmail")
 @CacheLookup
 WebElement txtEmail;
 
 @FindBy (how = How.ID, using="SearchFirstName")
 @CacheLookup
 WebElement txtfirstName;
 @FindBy (how = How.ID, using="SearchLastName")
 @CacheLookup
 WebElement txtLastName;
 
 @FindBy (how = How.ID, using="search-customers")
 @CacheLookup
 WebElement btnSearch;

 
 @FindBy(how= How.ID, using="customers-grid")
 @CacheLookup
 WebElement table;
		 
 @FindBy(how= How.XPATH, using="//table[@id=\"customers-grid\"]/tbody/tr")
 @CacheLookup
List<WebElement> tableRows;
 
 @FindBy(how= How.XPATH, using="//table[@id=\"customers-grid\"]/tbody/tr/td")
 @CacheLookup
List<WebElement> tableCols;
 
 public void setEmail(String email)
 {
	 txtEmail.sendKeys(email);
 }
 public void setFirstName(String firstname)
 {
	 txtfirstName.sendKeys(firstname);
 }
 public void setLasttName(String lastname)
 {
	 txtLastName.sendKeys(lastname);
 }
 public void clickBtn()
 {
	 btnSearch.click();
 }
 public int getNumOfRows()
 {
	 return(tableRows.size()) ;
 }
 public int getNumOfCols()
 {
	 return( tableCols.size()) ;
 }
 public boolean setCustomerByEmail(String email)
 {
	 boolean flag=false;
	 for(int i=1; i<=getNumOfRows(); i++)
	 {
		String emailid= ldriver.findElement(By.xpath("//table[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]")).getText();
		
		if(emailid.equals(email))
		{
			flag =true;
			break;
		}
		
	 }
	 return flag;
 }
 public boolean setCustomerByName(String Name)
 {
	 boolean flag=false;
	 for(int i=1; i<=getNumOfRows(); i++)
	 {
		String name= ldriver.findElement(By.xpath("//table[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]")).getText();
		
		if(name.equals(Name))
		{
			flag =true;
			break;
		}
		
	 }
	 return flag;
 }
 
}
