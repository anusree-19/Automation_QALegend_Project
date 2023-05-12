package com.QALegend.qa.Testcases;

import com.QALegend.qa.Base.TestBase;
import com.QALegend.qa.Pages.LoginPage;
import com.QALegend.qa.Pages.UserManagementpage;
import com.QALegend.qa.Util.Datadrivenutility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class UsersTestcases extends TestBase{
	LoginPage lp;
	UserManagementpage usr;
	public Logger logger;
	public UsersTestcases()
	{
		super();
	}
	
	@BeforeMethod(groups={"Regression","Sanity"})
	@Parameters("browser")
	
	public void Setup(String browser)
	{
		logger=LogManager.getLogger(this.getClass());
		Initialization(browser);
		lp=new LoginPage();
		lp.LoginwithValidCredentials(prop.getProperty("Username"), prop.getProperty("password"));
		usr=new UserManagementpage();
	}
	
	
	@Test(priority=1, enabled=true, dataProvider = "testData", dataProviderClass=Datadrivenutility.class)
	public void AddUserTC1(String surnme,String frstname,String lastnme,String roles, String password, String confirmpassword)
	{
		String successmsg=usr.AddUser(surnme,frstname,lastnme,roles,password,confirmpassword);
		Assert.assertEquals(successmsg,"User added successfully");
	}
	
	@Test(priority=2, enabled=true)
	public void AddUserwithoutFrstnameTC2()
	{
		//Assert.assertEquals(errormsg3, "This field is required.");
	}
	
	@Test(priority=3, enabled=true)
	
	public void SearchUserTC3()
	{
		
	}
	
	@Test(priority=4, enabled=true)
	public void EditUserTC4()
	{
		//Assert.assertEquals(errormsg3, "User updated successfully");
	}

}
