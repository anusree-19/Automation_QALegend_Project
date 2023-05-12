package com.QALegend.qa.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop= new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}
	
	public static void Initialization(String browsername)
	{
		//String browsername=prop.getProperty("Browser");
		
		if(browsername.equals("Chrome")){
            ChromeOptions ops= new ChromeOptions();
            ops.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(ops); 
        }
        else if(browsername.equals("FF")){
        
            driver = new FirefoxDriver(); 
        }
        else if(browsername.equals("Edge")){

            driver = new EdgeDriver(); 
        }
        else if(browsername.equals("safari")){
            driver=new SafariDriver();
        }
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("Url"));
	}
	
	

}
