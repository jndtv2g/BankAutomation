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


public class ProductListingPage extends PageFunctions {
	
    WebDriver driver;
//    By products = By.linkText("Products");
    By products = By.xpath("//a[contains(., 'Products')]");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    By product1 = By.cssSelector("input[data-product-id='1'");
    By emptyCartMsg = By.xpath("//*[text()='Cart is empty!']");
    Properties props1=new Properties();
    Logger demologger1;
    PageFunctions function1;
    
    
    
    // Initialize properties file here for LoginAssertElements.properties
    // Initialize logger here
    public ProductListingPage(WebDriver driver) throws InterruptedException, IOException {
    	this.driver = driver;
    	demologger1 = LogManager.getLogger(Login.class);
    	String filepath1 = "D:\\eclipse-workplace\\v2\\src\\test\\java\\LoginAssertElements.properties";
    	FileReader reader1=new FileReader(filepath1);
    	props1.load(reader1);
    	function1 = new PageFunctions();
    }
    
    
    // Navigate to website
    public void navigateToSite() throws InterruptedException {
    	driver.get(props1.getProperty("searchTerm"));
    	String actualTitleHomepage = driver.getTitle();
    	Assert.assertEquals(props1.getProperty("expectedTitleHomepage"), actualTitleHomepage);
    	demologger1.info("Actual page title is correct");
    	function1.delayPage();
    }
   
    // Navigate to product listing page
    public void goToProductListingPage() throws InterruptedException{
    	driver.findElement(products).click();
    	demologger1.info("Navigated to Products page successfully");
    	function1.delayPage();
    }
    
    // Add a product to cart
    public void addProductToCart() throws InterruptedException{
    	driver.findElement(product1).click();
    	demologger1.info("Added a product to cart successfully");
    	function1.delayStep();
    	function1.delayPage();
    }
    
}
