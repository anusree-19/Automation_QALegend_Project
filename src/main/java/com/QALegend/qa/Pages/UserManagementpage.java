package com.QALegend.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import  com.QALegend.qa.Util.GenericUtility;

import com.QALegend.qa.Base.TestBase;

public class UserManagementpage extends TestBase {
	
	GenericUtility util=new GenericUtility();
	@FindBy(linkText = "User Management")
    WebElement usermanagement;
	
	@FindBys({
        @FindBy(tagName="button"),})
         List<WebElement>tour;
	
	
	@FindBy(linkText = "Users")
    WebElement userslink;
	
	@FindBy(linkText = "Add")
    WebElement addbtn;
	
	@FindBy(id = "surname")
    WebElement surname;
	
	@FindBy(id = "first_name")
    WebElement firstname;
	
	@FindBy(id = "last_name")
    WebElement lastname;
	
	@FindBy(id = "email")
    WebElement email;
	
	@FindBy(xpath = "//select[@id='role']")
	  WebElement role;
	
	@FindBy(id = "password")
    WebElement pwd;
	
	@FindBy(id = "confirm_password")
    WebElement confirmpwd;
	
	@FindBy(xpath = "//button[@id='submit_user_button']") 
	  WebElement submitbtn;
	
	@FindBy(xpath="//div[contains(text(),'User added successfully')]")
	  WebElement successmsg;
	
	@FindBy(xpath="//label[@id='first_name-error']")
	  WebElement errormsg;
	
	@FindBy(xpath="//input[@type='search']")
	  WebElement search;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	  WebElement edit;
	
	@FindBy(xpath="//input[@id='email']")
	  WebElement editemail;

	@FindBy(xpath="//parent::div//input[@type='hidden' and @id='status_span']")
	  WebElement successmessage;
	
	public UserManagementpage()
	{
        PageFactory.initElements(driver, this);
    }
	
	public String AddUser(String surnme,String frstname,String lastnme,String roles, String password, String confirmpassword)
	{
		tour.get(11).click();
		usermanagement.click();
		userslink.click();
		addbtn.click();
		surname.sendKeys(surnme);
		firstname.sendKeys(frstname);
		lastname.sendKeys(lastnme);
		email.sendKeys(util.randomeString() + "@gmail.com");
		Select pgmselect= new Select(role);
		pgmselect.selectByVisibleText(roles);
		
		pwd.sendKeys(password);
		confirmpwd.sendKeys(confirmpassword);
		submitbtn.click();
		return successmsg.getText();
	}
	
	public String AddUserwithoutFrstname()
	{
		usermanagement.click();
		userslink.click();
		addbtn.click();
		surname.sendKeys();
		lastname.sendKeys();
		email.sendKeys();
		pwd.sendKeys();
		confirmpwd.sendKeys();
		submitbtn.click();
		return errormsg.getText();
	}
	
	public void SearchUser(String str)
	{
		usermanagement.click();
		userslink.click();
		search.sendKeys(str);
		
	}
	
	public String EditUser(String str)
	{
		usermanagement.click();
		userslink.click();
		search.sendKeys(str);
		edit.click();
		editemail.clear();
		editemail.sendKeys();
		submitbtn.click();
		return successmsg.getText();
	}
	
	
	
	
}
