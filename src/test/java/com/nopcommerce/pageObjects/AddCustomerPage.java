package com.nopcommerce.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class AddCustomerPage 
{
	WebDriver ldriver;
	WebElement listitem;
   public AddCustomerPage(WebDriver rdriver)
    {
	ldriver=rdriver;
	PageFactory.initElements(ldriver,this);
	ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
   
    By lnkcustomers_menu= By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
   //By lnkcustomers_menuitem= By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]"); 
   By lnkcustomers_menuitem= By.xpath("(//span[contains(text(),\"Customers\")][@class=\"menu-item-title\"])[1]"); 
   By btnAddnew=By.xpath("//a[@class='btn bg-blue']");
   
   By txtEmail=By.id("Email");
   By txtPassword=By.id("Password");
   By txtfirstname=By.id("FirstName");
   By txtlastname=By.id("LastName");
   By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
  
   By txtDob=By.id("DateOfBirth");
   By txtCompany=By.id("Company");
   By checktax=By.id("IsTaxExempt");
   By newsltr=By.xpath("//input[@value=\"2\"]");
   
   By textcustomerroles= By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
   By listitemadministrator=By.xpath("//li[contains(text(),\"Administrators\")]");
   By listitemforummodetar=By.xpath("//li[contains(text(),\"Forum Moderators\")]");
   By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
   By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
   
   By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
   
   By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By txtmsg=By.xpath("//div[@class='alert alert-success alert-dismissable']");
	
	//Action methods
			public void clickOnCustomersMenu()
			{
				ldriver.findElement(lnkcustomers_menu).click();
			}
			public void clickOnCustomersMenuItem() 
			{
				ldriver.findElement(lnkcustomers_menuitem).click();
			}
			public void clickOnAddnew() {
				ldriver.findElement(btnAddnew).click();
			}
			
			public void setEmail(String email)
			{
				ldriver.findElement(txtEmail).sendKeys(email);;
			}
			public void setPassword(String password)
			{
				ldriver.findElement(txtPassword).sendKeys(password);
			}
			public void setFirstName(String fname)
			{
				ldriver.findElement(txtfirstname).sendKeys(fname);
			}
			
			public void setLastName(String lname)
			{
				ldriver.findElement(txtlastname).sendKeys(lname);
			}
			
			public void setDob(String dob)
			{
				ldriver.findElement(txtDob).sendKeys(dob);
			}
			
			public void setCompanyName(String comname)
			{
				ldriver.findElement(txtCompany).sendKeys(comname);
			}

			public void setCustomerRoles(String role) throws InterruptedException 
				{
				
					ldriver.findElement(textcustomerroles).click();
				 Thread.sleep(3000);
					
					if(role.equals("Registered"))
					{
						listitem=ldriver.findElement(lstitemRegistered); 
					}
					else if(role.equals("Administrators"))
					{
						listitem=ldriver.findElement(listitemadministrator); 
					}
					else if(role.equals("Guests"))
					{
						// Here user can be Registered (or) Guest, only one
						//ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click(); //delete registered
						ldriver.findElement(By.xpath("//span[contains(text(),\"delete\")]")).click();
						listitem=ldriver.findElement(lstitemGuests);
					}
					else if(role.equals("Vendors"))
					{
						listitem=ldriver.findElement(lstitemVendors);
					}
					else
					{
						listitem=ldriver.findElement(lstitemGuests);
					}
							
					//listitem.click();
					
					JavascriptExecutor js = (JavascriptExecutor)ldriver;
					js.executeScript("arguments[0].click();", listitem);
			}

			public void setManagerOfVendor(String value)
			{
				Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
				drp.selectByVisibleText(value);
			}
			
			public void setGender(String gender)
			{
				if(gender.equals("Male"))
				{
					ldriver.findElement(rdMaleGender).click();
				}
				else if(gender.equals("Female"))
				{
					ldriver.findElement(rdFeMaleGender).click();
				}
				else
				{
					ldriver.findElement(rdFeMaleGender).click();//Default
				}
				
			}
			public void setAdminContent(String content)
			{
				ldriver.findElement(txtAdminContent).sendKeys(content);
			}
			
			public void clickOnSave()
			{
				ldriver.findElement(btnSave).click();
			}
			
			public boolean verifyConfirmationMsg()
			{
				String msg=ldriver.findElement(txtmsg).getText();
				if (msg.contains("The new customer has been added successfully"))
				{
					return true;
				}
				else
				{
					return false;
				}
		
			}
			
			
			
			
			
			
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
   
}
