package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.testBase.BaseClass;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginDATA")
     void loginTest(String uname ,String pw, String exp) throws InterruptedException
     {
		logger.info("*******TC_LoginDDT_002 is starting*****");
		driver.get(configpropfile.getProperty("baseURL"));
		LoginPage lp = new LoginPage(driver);
		logger.info("*****providing login details****");
		lp.setemail(uname);
		lp.setpassword(pw);
		lp.clicklogin();
		
		String exp_value = "Dashboard / nopCommerce administration";
		String actual_value = driver.getTitle();
		if(exp_value.equals(actual_value))
		{
			if(exp.equals("Pass"))
			{
				logger.info("*****TC_LoginDDT_002passed***");
				Thread.sleep(3000);
				lp.clicklogout();
				Assert.assertTrue(true);
			}
			else if(exp.equals("Fail"))
			{
				logger.warn("**************** TC_LoginDDT_002 Failed************* ");
				Thread.sleep(3000);
				lp.clicklogout();
				
				Assert.assertTrue(false);
			}
		}
		else if(!exp_value.equals(actual_value))
		{
			if(exp.equals("Pass"))
			{
				logger.info("*****TC_LoginDDT_002 is failed***");
				Assert.assertTrue(false);
			}
			else if(exp.equals("Fail"))
			{
				logger.info("*****TC_LoginDDT_002 is passed***");
				Assert.assertTrue(true);
			}
			
		}
		logger.info("**************** Finished TC_LoginDDT_002 ************* ");
		
	 }
     @DataProvider(name="LoginDATA")
     String[][] getData() throws IOException
     {
    	 String path="./"+"TestData/LoginData.xlsx";
    	 int rowcount=XLUtils.getRowCount(path, "Sheet1");
    	 int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
    	 String loginData[][]= new String[rowcount][colcount];
    	 
    	 for(int i=1; i<=rowcount; i++)
    	 {
    		 for(int j=0;j<colcount;j++)
    		 {
    			 loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
    		 }
    	 }
    	return loginData;
    	 
     }
}
