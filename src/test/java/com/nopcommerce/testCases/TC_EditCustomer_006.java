package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.EditCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_EditCustomer_006 extends BaseClass
{
 @Test
 public void editCustomer() throws InterruptedException, IOException
 {
	 logger.info("*******TC-LoginTest-001 starting*****");
		driver.get(configpropfile.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		logger.info("*****providing login details****");
		lp.setemail(configpropfile.getProperty("useremail"));
		lp.setpassword(configpropfile.getProperty("password"));
		lp.clicklogin();
		
	AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		SearchCustomerPage searchcust=new SearchCustomerPage (driver);
		searchcust.setEmail("brenda_lindgren@nopCommerce.com");
		searchcust.clickBtn();
		Thread.sleep(2000);
		
		EditCustomerPage ep=new EditCustomerPage(driver);
		ep.clickEdit();
		Thread.sleep(2000);
		ep.setfrstN();
		ep.setfrstN("Brendass123");
		ep.clickSave();
		boolean result=ep.msg();
		if(result=true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"editCustomer");
			Assert.assertTrue(false);
		}
		logger.info("****end of testcase6*****");
		

}


}
