package com.orderApp.WebScript;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.orderApp.POM.POM_LoginPage;
import utils.DriverFactory;


public class LoginPage {
	
    WebDriver driver;
    public String url="https://uat-buyer-app.boohoo.com/";

	
	@BeforeTest
	public void beforeTest() {
	    driver=DriverFactory.getBrowser("chrome");
		driver.get(url);	
	}
	
	@Test
	public void Login() throws IOException, InterruptedException {
		POM_LoginPage loginPage= new POM_LoginPage(driver);
		loginPage.SignIn();
	}
	
	@AfterTest
	public void AfterTest() {
		driver.quit();
	}
}
