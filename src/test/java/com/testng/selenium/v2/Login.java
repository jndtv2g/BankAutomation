package com.testng.selenium.v2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login {
	
	public WebDriver driver;
	Properties readProperties;
	By email = By.name("email");
	By password = By.name("password");
    By login = By.linkText("Signup / Login");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    //public WebElement errMsg = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
    
    public Login(WebDriver driver) {
    	this.driver = driver;
    }
   
    // Navigate to login screen
    public void clickOnLogin() {
    	driver.findElement(login).click();
    }
    
    // Set email in field
	public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }
    
    // Set password in field
    public void setPassword(String strPassword) {
    	driver.findElement(password).sendKeys(strPassword);
    }
    
    // Click on Login button once fields are populated
    public void clickLogin() {
    	driver.findElement(loginBtn).click();
    }
 
}
