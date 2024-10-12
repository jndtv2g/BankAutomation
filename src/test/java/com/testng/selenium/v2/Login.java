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


public class Login {
	
    WebDriver driver;
	By email = By.name("email");
	By password = By.name("password");
    By login = By.linkText("Signup / Login");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    //errMsg = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
    Properties props1=new Properties();
    Logger demologger1;
    
    public Login(WebDriver driver) throws InterruptedException, IOException {
    	this.driver = driver;
    	demologger1 = LogManager.getLogger(Login.class);
    	String filepath1 = "D:\\eclipse-workplace\\v2\\src\\test\\java\\LoginAssertElements.properties";
    	FileReader reader1=new FileReader(filepath1);
    	props1.load(reader1);
    }
    
//    public void initializeLogger()  {
//    	
//        FileReader reader1=new FileReader(filepath1);
//        // Initialize logger here
//		
//    }
//    
    public void navigateToSite() {
    	driver.get(props1.getProperty("searchTerm"));
    	String actualTitleHomepage = driver.getTitle();
    	Assert.assertEquals(props1.getProperty("expectedTitleHomepage"), actualTitleHomepage);
    	demologger1.info("Actual page title is correct");
    }
    
//    public void getHomePageTitle() {
//    	String actualTitleHomepage = driver.getTitle();
//    	Assert.assertEquals(props1.getProperty("expectedTitleHomepage"), actualTitleHomepage);
//    	demologger1.info("Actual page title is correct");
//    }
   
    // Navigate to login screen
    public void clickOnLogin() {
    	driver.findElement(login).click();
    	demologger1.info("Signup / Login link clicked successfully");
    	String actualTitleLogin = driver.getTitle();
		Assert.assertEquals(props1.getProperty("expectedTitleLogin"), actualTitleLogin);
    	demologger1.info("Actual page title is correct");
    }
    
    // Set email in field
	public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
        demologger1.info("Email field populated");
    }
    
    // Set password in field
    public void setPassword(String strPassword) {
    	driver.findElement(password).sendKeys(strPassword);
    	demologger1.info("Password field populated");
    }
    
    // Click on Login button once fields are populated
    public void clickLogin() {
    	driver.findElement(loginBtn).click();
    	demologger1.info("Login button clicked successfully");
    }
 
}
