package com.qa.model.challange6;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;


public class MainPage {

		@FindBy (xpath = "/html/body/div[2]/div/div/div/div/div[2]/form/div/div[1]/input")
		private WebElement enterTextBar;
	
		public void mainPage(String sampleString, Actions action) {
				
			enterTextBar.sendKeys(sampleString);
			action.sendKeys(Keys.ENTER).perform();
			
		}
	
}
