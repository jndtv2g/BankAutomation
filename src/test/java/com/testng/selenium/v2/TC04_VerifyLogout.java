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
//import org.apache.logging.slf4j.*;

/**
 * 
 */
@Test
public class TC04_VerifyLogout {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public void VerifyLogout() throws InterruptedException, IOException { 
		// TODO Auto-generated method stub
		
		// Variables here
		Logger demologger;
		ChromeOptions options;
		WebDriver driver;
		Login login;
		PageFunctions function;
		String filepath = "D:\\eclipse-workplace\\v2\\src\\test\\java\\TestData.properties";
		
//		// Initialize properties file here for TestData.properties
//		Properties props=new Properties();
//		FileReader reader=new FileReader(filepath);
//		props.load(reader);
		
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
		login = new Login(driver);
		
		// Navigate to the website
		login.navigateToSite();

		// Maximize current window
		driver.manage().window().maximize();
		
		// Click on Login button on page
		login.clickOnLogin();
		
		// Enter credentials on page
		login.setValidEmail();
		login.setValidPassword();
		login.clickValidLoginButton();
		
		// Click on Logout button on page
		login.clickLogoutButton();
		
		
		// Close window
		driver.close();
		
		
	}

}
