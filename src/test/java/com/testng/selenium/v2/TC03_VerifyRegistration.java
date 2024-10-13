/**
 * 
 */
package com.testng.selenium.v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.slf4j.*;

/**
 * 
 */
public class TC03_VerifyRegistration {

	/**
	 * @param args
	 * @throws IOException 
	 */

	
	@Test
	public static void main(String[] args) throws InterruptedException, IOException { 
		// TODO Auto-generated method stub
		
		// Variables here
		Logger demologger;
		ChromeOptions options;
		WebDriver driver;
		Login login;
		Register register;
		PageFunctions function;
		String filepath = "D:\\eclipse-workplace\\v2\\src\\test\\java\\TestData.properties";
		
		// Initialize properties file here for TestData.properties
		Properties props=new Properties();
		FileReader reader=new FileReader(filepath);
		props.load(reader);
		
		// Initialize logger here
		demologger = LogManager.getLogger(TC03_VerifyRegistration.class);
		
		// Initialize ChromeOptions (script not running without this)
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        // Initialize PageFunctions here
 		function = new PageFunctions();
     		
        // Set the path to ChromeDriver.exe
        function.setPropertyPath();
        
        // Initialize WebDriver with ChromeOptions as parameter
		driver = new ChromeDriver(options);
		
		// Initialize Login script class here
		register = new Register(driver);
		
		// Navigate to the website
		register.navigateToSite();

		// Maximize current window
		driver.manage().window().maximize();
		
		// Click on Login button on page
		register.clickOnLogin();

		// Enter full name and email to initiate registration here
		register.setSignupFullName();
		
		register.setSignupEmail();
		
		register.clickSignupBtn();
		
		// Perform registration steps here
		register.setGender();
		
		register.setPassword();
		
		register.setBirthDate();
		
		register.setBirthMonth();
		
		register.setBirthYear();
		
		register.setFirstName();
		
		register.setLastName();
		
		register.setCompany();
		
		register.setAddressLine1();
		
		register.setAddressLine2();
		
		register.setCountry();
		
		register.setState();
		
		register.setCity();
		
		register.setZipcode();
		
		register.setMobileNumber();
		
		register.clickCreateAccBtn();
		
		// Close window
		//driver.close();
		
		
	}

}
