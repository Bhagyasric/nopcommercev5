package com.nopcommerce.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;


public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(configpropfile.getProperty("baseURL"));
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(configpropfile.getProperty("useremail"));
		lp.setpassword(configpropfile.getProperty("password"));
		lp.clicklogin();
		logger.info("***************   TC_AddCustomerTest_003 statred  *********** ");
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();

		logger.info("***************  Providing customer details  *********** ");

		
		String email=randomestring()+"@gmail.com";
		
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("bub");
		addcust.setLastName("prnt");
		addcust.setGender("Female");
		addcust.setDob("7/05/1990"); // Format: D/MM/YYY
		addcust.setCompanyName("busyQA");
		addcust.setCustomerRoles("Vendors");
		addcust.setManagerOfVendor("Vendor 2");
		Thread.sleep(3000);
		addcust.setAdminContent("This is for testing.........");
		addcust.clickOnSave();

		// validation
		if (addcust.verifyConfirmationMsg()) 
		{
			logger.info("***************  Customer added succesfully *********** ");
			Assert.assertTrue(true);

		} else 
		{
			logger.error("*************** Customer Not added succesfully *********** ");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

		logger.info("***************   TC_AddCustomerTest_003 Finished  *********** ");
		
	}
}
