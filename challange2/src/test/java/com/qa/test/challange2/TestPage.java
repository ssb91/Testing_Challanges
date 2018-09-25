package com.qa.test.challange2;

//import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.model.challange2.MainPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestPage {
	
	ChromeDriver driver;
	
	ExtentReports extent;
	ExtentTest test;

	Actions action;
	
	@Before
	public void setup() {

		extent = new ExtentReports("C:/Users/Admin/Documents/Reports.html", true);

		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();

		action = new Actions(driver);
		
	}
	
	@After 
	public void teardown() {
		
		
	}
	
	
	@Test

	public void testDemo() {
			
		driver.get("http://testingchallenges.thetestingmap.org/challenge2.php");
	
		test = extent.startTest("enter a sample string");
		
		MainPage homePage = PageFactory.initElements(driver, MainPage.class);
		
		homePage.mainPage("1", action);
		homePage.mainPage("1,000", action);
		homePage.mainPage("1.1", action);		
		homePage.mainPage("1:1", action);
		homePage.mainPage("1/1", action);
		homePage.mainPage("1-1", action);		
		homePage.mainPage(".1", action);
		homePage.mainPage("A1", action);
		homePage.mainPage("A-1", action);
				
		String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/div/div/input")).getAttribute("validationMessage");		
		assertEquals(message, "Please enter a number.");

		test.log(LogStatus.PASS, "non-numeric string rejected");
		
		extent.endTest(test);
		extent.flush();
		
	}

}