package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_SearchCustomerByEmail_004 extends BaseClass
{
	@Test
    public void searchCustomerByEmail() throws InterruptedException, IOException
    {
		
		logger.info("*******TC-SearchCustomerByEmail_004*****");
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
		
		//Provide EMAIL in Search Page
		SearchCustomerPage searchcust=new SearchCustomerPage (driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
		searchcust.clickBtn();
		Thread.sleep(3000);
		boolean result=	searchcust.setCustomerByEmail("victoria_victoria@nopCommerce.com");
		if(result=true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"searchCustomerByEmail");
			Assert.assertTrue(false);
		}
		logger.info("****end of testcase4*****");
		
	}
}
