package com.testng.selenium.v2;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Properties.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.slf4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login extends PageFunctions {
	
    WebDriver driver;
	By email = By.cssSelector("input[data-qa='login-email'");
	By password = By.cssSelector("input[data-qa='login-password'");
	By login = By.linkText("Signup / Login");
	By loginBtn = By.cssSelector("button[data-qa='login-button'");
//    By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    By errMsg = By.xpath("//*[text()='Your email or password is incorrect!']");
    By logout = By.linkText("Logout");
    Properties props1=new Properties();
    Logger demologger1;
    PageFunctions function;
    
    
    // Initialize properties file here for LoginAssertElements.properties
    // Initialize logger here
    public Login(WebDriver driver) throws InterruptedException, IOException {
    	this.driver = driver;
    	demologger1 = LogManager.getLogger(Login.class);
    	String filepath1 = "D:\\eclipse-workplace\\v2\\src\\test\\java\\LoginAssertElements.properties";
    	FileReader reader1=new FileReader(filepath1);
    	props1.load(reader1);
    	function = new PageFunctions();
    }
    

    
    public void navigateToSite() throws InterruptedException {
    	driver.get(props1.getProperty("searchTerm"));
    	String actualTitleHomepage = driver.getTitle();
    	Assert.assertEquals(props1.getProperty("expectedTitleHomepage"), actualTitleHomepage);
    	demologger1.info("Actual page title is correct");
    	function.delayPage();
    }
   
    // Navigate to login screen
    public void clickOnLogin() throws InterruptedException {
    	driver.findElement(login).click();
    	demologger1.info("Signup / Login link clicked successfully");
    	String actualTitleLogin = driver.getTitle();
		Assert.assertEquals(props1.getProperty("expectedTitleLogin"), actualTitleLogin);
    	demologger1.info("Actual page title is correct");
    	function.delayStep();
    }
    
    // Set valid email in field
	public void setValidEmail() throws InterruptedException {
        driver.findElement(email).sendKeys(props1.getProperty("validEmail"));
        demologger1.info("Email field populated");
        function.delayStep();
    }
    
    // Set valid password in field
    public void setValidPassword() throws InterruptedException {
    	driver.findElement(password).sendKeys(props1.getProperty("validPassword"));
    	demologger1.info("Password field populated");
    	function.delayStep();
    }
    
    // Set invalid email in field
    public void setInvalidEmail() throws InterruptedException {
    	driver.findElement(email).sendKeys(props1.getProperty("invalidEmail"));
    	demologger1.info("Email field populated");
    	function.delayStep();
    }
    
    // Set invalid password in field
    public void setInvalidPassword() throws InterruptedException {
    	driver.findElement(password).sendKeys(props1.getProperty("invalidPassword"));
    	demologger1.info("Password field populated");
    	function.delayStep();
    }
    
    // Click on Login button once fields are populated
    public void clickInvalidLoginButton() throws InterruptedException {
    	driver.findElement(loginBtn).click();
    	demologger1.info("Login button clicked successfully");
    	
    	if (driver.findElement(errMsg).isDisplayed()) {
    		demologger1.error("Invalid credentials entered");
    	}
    	else {
    		demologger1.info("Valid credentials entered");
    	}
    	function.delayPage();
    }
    
    // Click on Login button once fields are populated
    public void clickValidLoginButton() throws InterruptedException {
    	driver.findElement(loginBtn).click();
    	demologger1.info("Login button clicked successfully");
		demologger1.info("Valid credentials entered");
    	function.delayPage();
    }
    
    // Click on Logout button
    public void clickLogoutButton() throws InterruptedException {
    	driver.findElement(logout).click();
    	demologger1.info("Logout button clicked");
    	function.delayPage();
    }
 
}
