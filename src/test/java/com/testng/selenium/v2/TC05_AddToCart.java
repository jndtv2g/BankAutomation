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
public class TC05_AddToCart {

	/**
	 * @param args
	 * @throws IOException 
	 */


	public void VerifyAddToCart() throws InterruptedException, IOException { 
		// TODO Auto-generated method stub
		
		// Variables here
		Logger demologger;
		ChromeOptions options;
		WebDriver driver;
		Login login;
		ProductListingPage plp;
		PageFunctions function;
		String filepath = "D:\\eclipse-workplace\\v2\\src\\test\\java\\TestData.properties";
		
		// Initialize properties file here for TestData.properties
		Properties props=new Properties();
		FileReader reader=new FileReader(filepath);
		props.load(reader);
		
		// Initialize logger here
		demologger = LogManager.getLogger(TC02_VerifyValidLogin.class);
		
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
		
		// Initialize ProductListingPage class here
		plp = new ProductListingPage(driver);
		
		// Navigate to the website
		login.navigateToSite();
		function.delayPage();
		

		// Maximize current window
		driver.manage().window().maximize();
		function.delayPage();
		
		// Click on Login button on page
		login.clickOnLogin();

		// Test message here when switching screen
		function.delayPage();
		
		// Login using existing email and password
		login.setValidEmail();
		login.setValidPassword();
		login.clickValidLoginButton();
		
		// Go to product listing page
		plp.goToProductListingPage();

		// Close window
//		driver.close();
		
		
	}

}
