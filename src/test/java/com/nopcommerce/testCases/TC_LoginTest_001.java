package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;

public class TC_LoginTest_001 extends BaseClass 
{

	@Test
	public void logintest() throws IOException 
	{
		logger.info("*******TC-LoginTest-001 starting*****");
		driver.get(configpropfile.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		logger.info("*****providing login details****");
		lp.setemail(configpropfile.getProperty("useremail"));
		lp.setpassword(configpropfile.getProperty("password"));
		lp.clicklogin();
		
		String exp_value = "Dashboard / nopCommerce administration";
		String actual_value = driver.getTitle();
		SoftAssert softassert=new SoftAssert();
		if (exp_value.equals(actual_value)) 
		{
			logger.info("*****logintest passed*****");
			//Assert.assertTrue(true);
			softassert.assertTrue(true);
			
		} 
		else 
		{
			logger.error("****login test failed*****");
			captureScreen(driver, "loginTest");
           // Assert.assertTrue(false);
			
			softassert.assertTrue(false);
			
		}
		logger.info("****finished TC logintest 001 ****");
        softassert.assertAll();
	}

}
