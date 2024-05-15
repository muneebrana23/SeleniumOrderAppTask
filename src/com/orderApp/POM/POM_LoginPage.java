package com.orderApp.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;
import static utils.ReadCredsProperty.getUserCredentials;
import static utils.ReadCredsProperty.getSelector;

import java.io.IOException;
import java.time.Duration;

public class POM_LoginPage {

	WebDriver driver;

	public POM_LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void SignIn() throws IOException, InterruptedException {

		driver.findElement(getSelector("loginEmail")).sendKeys(getUserCredentials("username"));
		driver.findElement(getSelector("loginPass")).sendKeys(getUserCredentials("password"));
		driver.findElement(getSelector("loginButton")).click();
		waitForElementDisplayed(getSelector("draftOrders"));
		driver.findElement(getSelector("draftOrders")).isDisplayed();
		
	}

	public void waitForElementDisplayed(By Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	}

}
