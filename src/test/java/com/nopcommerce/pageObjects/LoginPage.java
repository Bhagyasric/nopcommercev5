package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
    WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(ldriver, this);
    }
    @FindBy(name="Email")
    @CacheLookup
    WebElement txtemail;
    
    @FindBy(id="Password")
    @CacheLookup
    WebElement txtpassword;
    
    @FindBy(xpath="//input[@class=\"button-1 login-button\"]")
    @CacheLookup
    WebElement btnlogin;
    
    @FindBy(linkText="Logout")
    @CacheLookup
    WebElement linklogout;
    
    public void setemail(String uname)
    {
    	txtemail.clear();
    	txtemail.sendKeys(uname);
    }
   public void setpassword(String pw)
    {
    	txtpassword.clear();
    	txtpassword.sendKeys(pw);
    }
  public  void clicklogin()
    {
    	btnlogin.click();
    }
 public   void clicklogout()
    {
    	linklogout.click();
    }
    
    
    
    
    
    
    
    
}
