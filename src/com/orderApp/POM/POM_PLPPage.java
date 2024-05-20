package com.orderApp.POM;

import static utils.ReadCredsProperty.getSelector;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.CommonActions;

public class POM_PLPPage {
	
	WebDriver driver;
	CommonActions helpers;
	
	public POM_PLPPage(WebDriver driver) {
		this.driver=driver;
		this.helpers= new CommonActions(driver);
	} 
	
	public void SelectProduct() throws IOException {
		WebElement products=helpers.selectRandomItem(driver.findElements(getSelector("PLPproductsList")));
		products.click();

	}	
}
