package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.DeleteCustomer;
import com.nopcommerce.pageObjects.EditCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.pageObjects.SearchCustomerPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_DeleteCustomer_007 extends BaseClass
{
	@Test
 public void deleteCustomer() throws InterruptedException, IOException
 {
		 logger.info("*******TC-LoginTest-007 starting*****");
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
			searchcust.setEmail("bsp1@gmail.com");
			searchcust.clickBtn();
			Thread.sleep(2000);
			
			EditCustomerPage ep=new EditCustomerPage(driver);
			ep.clickEdit();
			
			DeleteCustomer dp=new DeleteCustomer(driver);
			dp.clickDltBtn();
			dp.clickDltBox();
			
			boolean result=ep.msg();
			if(result=true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver,"deleteCustomer");
				Assert.assertTrue(false);
			}
			logger.info("****end of testcase7*****");
 }
}
