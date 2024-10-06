package com.testng.selenium.v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login {
	
	WebDriver driver;
	By email = By.name("email");
	By password = By.name("password");
    By login = By.linkText("Signup / Login");
    
    public Login(WebDriver driver) {
    	this.driver = driver;
    }
    
    //Set user name in textbox
    
    public void clickOnLogin() {
    	driver.findElement(login).click();
    }
    
    // Set email in field
    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }
    
    // Set password in field
    public void setPassword(String strPassword) {
    	driver.findElement(email).sendKeys(strPassword);
    }
    
    
 
}
