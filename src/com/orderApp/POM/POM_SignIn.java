package com.orderApp.POM;

import static utils.ReadCredsProperty.getSelector;
import static utils.ReadCredsProperty.getUserCredentials;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.CommonActions;

public class POM_SignIn {
WebDriver driver;
	
	CommonActions helpers;
	public POM_SignIn(WebDriver driver) {
		this.driver=driver;	
		this.helpers = new CommonActions(driver);
	}
	
	public void SignIn() throws InterruptedException, IOException {
		helpers.waitForElementDisplayed(getSelector("emailField"));
		driver.findElement(getSelector("emailField")).sendKeys(getUserCredentials("PLTusername")); 
		driver.findElement(getSelector("submitButton")).click();
		helpers.waitForElementDisplayed(getSelector("passwordField"));
		driver.findElement(getSelector("passwordField")).sendKeys(getUserCredentials("PLTPassword")); 
		driver.findElement(getSelector("submitButton")).click();
	}
}
