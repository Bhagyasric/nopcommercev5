package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByName_005 extends BaseClass 
{

	@Test
    public void searchCustomerByName() throws InterruptedException, IOException
    {
		
		logger.info("*******TC-SearchCustomerByName_005*****");
		driver.get(configpropfile.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		logger.info("*****providing login details****");
		lp.setemail(configpropfile.getProperty("useremail"));
		lp.setpassword(configpropfile.getProperty("password"));
		lp.clicklogin();
		//Goto Search Page
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		//Provide FirstName and LastName in Search Page
		SearchCustomerPage searchcust=new SearchCustomerPage (driver);
		searchcust.setCustomerByName("Victoria Terces");
		
		searchcust.clickBtn();
		Thread.sleep(3000);
		boolean result=	searchcust.setCustomerByName("Victoria Terces");
		if(result=true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"searchCustomerByName");
			Assert.assertTrue(false);
		}
		logger.info("****end of testcase5*****");
		
	}
}
