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
 * This class consists of methods that can be used repetitively on multiple scripts
 */
public class PageFunctions {
	
	
	// Set property here
	public void setPropertyPath() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	}
	
	
	// Test method for delaying page loads
    public void delayPage() throws InterruptedException {
    	Thread.sleep(10000);
    }
    
    // Test method for delaying test steps
    public void delayStep() throws InterruptedException {
    	Thread.sleep(3000);
    }
    
 
}
