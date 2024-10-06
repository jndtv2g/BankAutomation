/**
 * 
 */
package com.testng.selenium.v2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
	 * @throws FileNotFoundException 
	 */

	
	@Test
	public static void main(String[] args) throws InterruptedException, FileNotFoundException { 
		// TODO Auto-generated method stub
		
		// Variables here
		final ChromeOptions options;
		final WebDriver driver;
		final String url = "https://automationexercise.com/";
		final Login login;
		final PageFunctions function;
		String expectedTitleHomePage = "Automation Exercise";
		String expectedTitleLogin = "Automation Exercise - Signup / Login";
		
		// Initialize file reader
		FileInputStream testData = new FileInputStream("D:\\automation\\data.txt");
		
		// Initialize ChromeOptions (script not running without this)
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        //Initialize PageFunctions here
 		function = new PageFunctions();
     		
        // Set the path to ChromeDriver
        function.setPropertyPath();
        
        // Initialize WebDriver with ChromeOptions as parameter
		driver = new ChromeDriver(options);
		
		// Initialize Login script class here
		login = new Login(driver);
		
		// Navigate to the website
		driver.get(url);
		
		// Validate landed site is correct
		String actualTitleHomepage = driver.getTitle();
		Assert.assertEquals(expectedTitleHomePage, actualTitleHomepage);
		
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
		Assert.assertEquals(expectedTitleLogin, actualTitleLogin);
		
		// Login using existing email and password
		login.setEmail(actualTitleLogin);
		
		
		// Close window
		driver.close();
		
		
	}

}
