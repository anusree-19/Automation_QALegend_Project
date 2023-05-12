

package com.QALegend.qa.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.QALegend.qa.Base.TestBase;

public class LoginPage extends TestBase{
	
	//PageObjects
	
		@FindBy(id = "username")
	    WebElement username;
		
		@FindBy(id = "password")
	    WebElement password;
		

		@FindBy(tagName = "button")
	    WebElement login;
		
		@FindBy(xpath = "//strong[contains(text(),'These credentials do not match our records.')]")
	    WebElement errormsg;
		
		@FindBy(xpath = "//a[@class='btn btn-link']")
	    WebElement forgotpwdlink;
		
		@FindBy(xpath = "//input[@id='email']")
	    WebElement email;
		
		@FindBy(xpath = "//button[@type='submit']")
	    WebElement send;
		
		//@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/form/div[1]/div/span/strong")
		//@FindBy(xpath= "//span//strong[contains(text(),'We can't find a user with that e-mail address')]")
		@FindBy(xpath = "//input[@id='email']//parent::div//span//strong")
	    WebElement errormsg1;
		
	//Actions
		
		//Driver Initialization
		
		public LoginPage()
		{
            PageFactory.initElements(driver, this);
        }
		
		public String LoginwithValidCredentials(String usr,String pwd)
		{
			username.sendKeys(usr);
			password.sendKeys(pwd);
			login.click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.tagName("button")));
			
			return driver.getCurrentUrl();
			
		}
		
		
		public String LoginwithInvalidCredentials(String usr,String pwd)
		{
			username.sendKeys(usr);
			password.sendKeys(pwd);
			login.click();
			return errormsg.getText();
			
		}
		
		public String Validusernameinvalidpwd(String usr,String pwd)
		{
			username.sendKeys(usr);
			password.sendKeys(pwd);
			login.click();
			return errormsg.getText();
		}
		
		public String Invalidusernamevalidpwd(String usr,String pwd)
		{
			username.sendKeys(usr);
			password.sendKeys(pwd);
			login.click();
			return errormsg.getText();
		}
		//public String Forgotpwd()
		public boolean Forgotpwd(String mailid)
		{
			forgotpwdlink.click();
			//email.sendKeys(mailid);
			email.sendKeys(mailid);
			send.click();
			//return errormsg1.getText();
			return errormsg1.isDisplayed();
		}
		

}
