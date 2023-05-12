package com.QALegend.qa.Testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.QALegend.qa.Base.TestBase;
import com.QALegend.qa.Pages.LoginPage;

public class LoginPageTestcases extends TestBase{
	
	LoginPage lp;
	public Logger logger;
	
	
	public LoginPageTestcases()
	{
		super();
	}
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	@BeforeMethod(groups={"Sanity"})
	@Parameters("browser")
	
	public void Setup(String browser)
	{
		logger=LogManager.getLogger(this.getClass());
		Initialization(browser);
		lp=new LoginPage();
		
	}
	
	@Test(priority=1, enabled=true, groups={"Regression","Sanity"})
	public void LoginwithValidCredentialsTC1()
	{
		logger.info("Starting login.....");
		logger.info("Entering the username and Password");
		String url=lp.LoginwithValidCredentials(prop.getProperty("Username"), prop.getProperty("password")); //Username and password values from config.properties
		Assert.assertEquals(url,"https://qalegend.com/billing/");
			
	}
	
	@Test(priority=2, enabled=true, groups={"Regression","Sanity"})
	
	public void LoginwithInValidCredentialsTC2()
	{
		String msg=lp.LoginwithInvalidCredentials(randomeString(),randomeString()); 
		Assert.assertEquals(msg,"These credentials do not match our records.");
			
	}
	
	@Test(priority=3, enabled=true, groups={"Regression"})
	public void ValidusernameinvalidpwdTC3()
	{
		String msg=lp.LoginwithInvalidCredentials(prop.getProperty("Username"),randomeString()); 
		Assert.assertEquals(msg,"These credentials do not match our records.");
			
	}
	
	@Test(priority=4, enabled=true, groups={"Regression"})
	public void InvalidusernamevalidpwdTC4()
	{
		String msg=lp.LoginwithInvalidCredentials(randomeString(),prop.getProperty("password")); 
		Assert.assertEquals(msg,"These credentials do not match our records.");
			
	}
	
	@Test(priority=5, enabled=true, groups={"Sanity"})
	public void ForgotpwdTC5()
	{
		//String str=prop.getProperty("email");
		//String msg1=lp.Forgotpwd(prop.getProperty("email"));
		//String msg1=lp.Forgotpwd(randomeString() + "@gmail.com");
		boolean msg1=lp.Forgotpwd(randomeString() + "@gmail.com");
		//Assert.assertEquals(msg1,"We can't find a user with that e-mail address.");
		System.out.println(msg1);
	}
	
	
	
	
	
	@AfterMethod(groups={"Regression","Sanity"})
	
	public void quit()
	{
		driver.quit();
	}
	
}
