package com.nopcommerce.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public Properties configpropfile;
	public Logger logger=LogManager.getLogger(this.getClass());

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws IOException 
	{
		//starting loading data in configpropfile object
		configpropfile=new Properties();
		//now we have to open data from file in readable format
		FileInputStream config=new FileInputStream( ".//Configuration//config.properties");
		configpropfile.load(config);
		//completed loading data
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		
		}
		else if(br.equals("ie"))
		{	
			//WebDriverManager.iedriver().setup();//Not working
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("edge"))
		{				
			//WebDriverManager.edgedriver().setup(); //Not working
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		File source= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		File target = new File("./" + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	public String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
