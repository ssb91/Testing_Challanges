package com.qa.test.challange6;

//import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.model.challange6.MainPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestPage {
	
//	ChromeDriver driver;
	
	static WebDriver driver;
	
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
			
		driver.get("http://testingchallenges.thetestingmap.org/challenge6.php");
	
		test = extent.startTest("enter a sample string");
		
		MainPage homePage = PageFactory.initElements(driver, MainPage.class);
		
		homePage.mainPage("31/12/2016 23:59", action);
		homePage.mainPage("01/01/2018 00:00", action);
		
		String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/form/div/div[1]/input")).getAttribute("validationMessage");		
		assertEquals(message, "Your input is not valid. Please use DD/MM/YYYY HH:MM");

		System.out.println(message);
		
		test.log(LogStatus.PASS, "invalid format string rejected");
		
		extent.endTest(test);
		extent.flush();
		
	}

}