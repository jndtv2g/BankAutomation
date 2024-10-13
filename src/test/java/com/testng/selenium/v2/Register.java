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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Register extends PageFunctions {
	
    WebDriver driver;
//    By signupFullName = By.name("name");
//    By signUpEmail = By.name("email");
    By signupFullName = By.cssSelector("input[data-qa='signup-name']");
    By signUpEmail = By.cssSelector("input[data-qa='signup-email']");
    By signUpBtn = By.cssSelector("button[data-qa='signup-button']");
    By genderMale = By.id("id_gender1");
    By genderFemale = By.id("id_gender2");
	By email = By.name("email");
	By password = By.name("password");
	By birthDate = By.id("days");
	By birthMonth = By.id("months");
	By birthYear = By.id("years");
	By newsletter = By.id("newsletter");
	By optin = By.id("optin");
	By firstName = By.id("first_name");
	By lastName = By.id("last_name");
	By company = By.id("company");
	By addressLine1 = By.id("address1");
	By addressLine2 = By.id("address2");
	By country = By.id("country");
	By state = By.id("state");
	By city = By.id("city");
	By zipcode = By.id("zipcode");
	By mobileNumber = By.id("mobile_number");
	
	
    By login = By.linkText("Signup / Login");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");
//    By createAccountBtn = By.xpath("//button[contains(text(),'Create Account')]");
    By createAccountBtn = By.cssSelector("button[data-qa='create-account']");
    Properties props1=new Properties();
    Logger demologger1;
    PageFunctions function1;
    
    
    
    // Initialize properties file here for LoginAssertElements.properties
    // Initialize logger here
    public Register(WebDriver driver) throws InterruptedException, IOException {
    	this.driver = driver;
    	demologger1 = LogManager.getLogger(Login.class);
    	String filepath1 = "D:\\eclipse-workplace\\v2\\src\\test\\java\\RegistrationData.properties";
    	FileReader reader1=new FileReader(filepath1);
    	props1.load(reader1);
    	function1 = new PageFunctions();
    }
    
    // Enter full name in Login/Signup page
    public void setSignupFullName() throws InterruptedException {
    	driver.findElement(signupFullName).sendKeys(props1.getProperty("signupFullName"));
    	demologger1.info("Fullname field populated");
    	function1.delayStep();
    }
    
    // Enter email in Login/Signup page
    public void setSignupEmail() throws InterruptedException {
    	driver.findElement(signUpEmail).sendKeys(props1.getProperty("signupEmail"));
    	demologger1.info("Password field populated");
    	function1.delayStep();
    }
    
    // Click on sign up button in Login/Signup page
    public void clickSignupBtn() throws InterruptedException {
    	driver.findElement(signUpBtn).click();
    	demologger1.info("Sign up button clicked");
    	function1.delayStep();
    }

    
    // Navigate to website
    public void navigateToSite() throws InterruptedException {
    	driver.get(props1.getProperty("searchTerm"));
    	String actualTitleHomepage = driver.getTitle();
    	Assert.assertEquals(props1.getProperty("expectedTitleHomepage"), actualTitleHomepage);
    	demologger1.info("Actual page title is correct");
    	function1.delayPage();
    }
   
    // Navigate to login/signup screen
    public void clickOnLogin() throws InterruptedException {
    	driver.findElement(login).click();
    	demologger1.info("Signup / Login link clicked successfully");
    	String actualTitleLogin = driver.getTitle();
		Assert.assertEquals(props1.getProperty("expectedTitleLogin"), actualTitleLogin);
    	demologger1.info("Actual page title is correct");
    	function1.delayPage();
    }
    
    // Set gender here
    public void setGender() throws InterruptedException {
    	driver.findElement(genderMale).click();
    	demologger1.info("Gender field selected");
    	function1.delayStep();
    	
    }
    
    // Set password here
    public void setPassword() throws InterruptedException {
    	driver.findElement(password).sendKeys(props1.getProperty("password"));
    	demologger1.info("Password field populated");
    	function1.delayStep();
    } 
    
    // Set birthdate here
    public void setBirthDate() throws InterruptedException {
    	Select selectBirthdate=new Select(driver.findElement(birthDate));
    	selectBirthdate.selectByValue("1");
    	demologger1.info("Birthdate field populated");
    	function1.delayStep();
    }
    
    // Set birthmonth here
    public void setBirthMonth() throws InterruptedException {
    	Select selectBirthmonth=new Select(driver.findElement(birthMonth));
//    	selectBirthmonth.selectByValue("January");
//    	selectBirthmonth.selectByVisibleText("January");
    	selectBirthmonth.selectByIndex(1);
    	demologger1.info("Birthmonth field populated");
    	function1.delayStep();
    }
    
    // Set birthyear here
    public void setBirthYear() throws InterruptedException {
    	Select selectBirthyear=new Select(driver.findElement(birthYear));
//    	selectBirthyear.selectByValue("1990");
    	selectBirthyear.selectByVisibleText("1990");
    	demologger1.info("Birthdate field populated");
    	function1.delayStep();
    }
    
    // Set first name here
    public void setFirstName() throws InterruptedException {
    	driver.findElement(firstName).sendKeys(props1.getProperty("firstName"));
    	demologger1.info("First name field populated");
    	function1.delayStep();
    }
    
    // Set last name here
    public void setLastName() throws InterruptedException {
    	driver.findElement(lastName).sendKeys(props1.getProperty("lastName"));
    	demologger1.info("Last Name field populated");
    	function1.delayStep();
    }
    
    // Set company here
    public void setCompany() throws InterruptedException {
    	driver.findElement(company).sendKeys(props1.getProperty("company"));
    	demologger1.info("Company field populated");
    	function1.delayStep();
    }
    
    // Set address line 1 here
    public void setAddressLine1() throws InterruptedException {
    	driver.findElement(addressLine1).sendKeys(props1.getProperty("addressLine1"));
    	demologger1.info("Address Line 1 field populated");
    	function1.delayStep();
    }
    
    // Set address line 2 here
    public void setAddressLine2() throws InterruptedException {
    	driver.findElement(addressLine2).sendKeys(props1.getProperty("addressLine2"));
    	demologger1.info("Address Line 2 field populated");
    	function1.delayStep();
    }
    
    // Select country from dropdown here
    public void setCountry() throws InterruptedException {
    	Select selectCountry=new Select(driver.findElement(country));
    	selectCountry.selectByValue("United States");
    	demologger1.info("Country field populated");
    	function1.delayStep();
    }
    
    // Set state here
    public void setState() throws InterruptedException {
    	driver.findElement(state).sendKeys(props1.getProperty("state"));
    	demologger1.info("State field populated");
    	function1.delayStep();
    }
    
    // Set city here
    public void setCity() throws InterruptedException {
    	driver.findElement(city).sendKeys(props1.getProperty("city"));
    	demologger1.info("State field populated");
    	function1.delayStep();
    }
    
    // Set zipcode here
    public void setZipcode() throws InterruptedException {
    	driver.findElement(zipcode).sendKeys(props1.getProperty("zipcode"));
    	demologger1.info("Zipcode field populated");
    	function1.delayStep();
    }
    
    // Set mobile number here
    public void setMobileNumber() throws InterruptedException {
    	driver.findElement(mobileNumber).sendKeys(props1.getProperty("mobileNumber"));
    	demologger1.info("Mobile number field populated");
    	function1.delayStep();
    }
    
    // Finalize registration here
    public void clickCreateAccBtn() throws InterruptedException{
    	driver.findElement(createAccountBtn).click();
    	demologger1.info("Create Account button clicked");
    	function1.delayPage();
    }
 
}
