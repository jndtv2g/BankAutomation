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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 */
public class v2 {

	/**
	 * @param args
	 * @throws IOException 
	 */

	
	@Test
	public static void main(String[] args) throws InterruptedException, IOException { 
		// TODO Auto-generated method stub
		
		// Variables here
		ChromeOptions options;
		WebDriver driver;
		Login login;
		PageFunctions function;
		String expectedTitleHomePage = "Automation Exercise";
		String expectedTitleLogin = "Automation Exercise - Signup / Login";
		String filepath = "D:\\eclipse-workplace\\v2\\src\\test\\java\\TestData.properties";
		
		// Testing properties file here
		Properties props=new Properties();
		FileReader reader=new FileReader(filepath);
		props.load(reader);
		
		
		
		// Initialize ChromeOptions (script not running without this)
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        // Initialize PageFunctions here
 		function = new PageFunctions();
     		
        // Set the path to ChromeDriver
        function.setPropertyPath();
        
        // Initialize WebDriver with ChromeOptions as parameter
		driver = new ChromeDriver(options);
		
		// Initialize Login script class here
		login = new Login(driver);
		
		// Navigate to the website
		driver.get(props.getProperty("searchTerm"));
		
		// Validate landed site is correct
		String actualTitleHomepage = driver.getTitle();
		Assert.assertEquals(props.getProperty("expectedTitleHomepage"), actualTitleHomepage);
		
		// Maximize current window
		driver.manage().window().maximize();
		function.delayPage();
		
		// Click on Login button on page
		login.clickOnLogin();

		// Test message here when switching screen
		System.out.println("Login button successfully clicked");
		function.delayPage();
			
		// Validate landed site is correct
		String actualTitleLogin = driver.getTitle();
		Assert.assertEquals(props.getProperty("expectedTitleLogin"), actualTitleLogin);
		
		// Login using existing email and password
		login.setEmail(props.getProperty("email"));
		login.setPassword(props.getProperty("password"));
		login.clickLogin();
		function.delayPage();
		
		// Close window
		//driver.close();
		
		
	}

}
