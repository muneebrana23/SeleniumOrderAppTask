package com.orderApp.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static utils.ReadCredsProperty.getSelector;

import java.io.IOException;

import helpers.CommonActions;

public class PLTHomePage {

	WebDriver driver;
	CommonActions helpers;

	public PLTHomePage(WebDriver driver) {
		this.driver = driver;
		this.helpers = new CommonActions(driver);
	}

	public void openAndValidateStore(String Url) throws InterruptedException, IOException {
		driver.get(Url);
		helpers.acceptCookiesPopUp(getSelector("CookiePopPp"));
		helpers.waitForElementDisplayed(getSelector("topNav"));
	}

	public void selectCategory() throws InterruptedException, IOException {
		WebElement item = helpers.selectRandomItem(driver.findElements(getSelector("Categories")));
		String val = item.getText();
		System.out.println("Cat is:" + val);
		if (val.equalsIgnoreCase("BEAUTY") || val.equalsIgnoreCase("EDIT")) {
			selectCategory();
		} else {
			item.click();
		}
	}

}
