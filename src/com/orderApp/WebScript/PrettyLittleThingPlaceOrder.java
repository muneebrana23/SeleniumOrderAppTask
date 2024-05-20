package com.orderApp.WebScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orderApp.POM.PLTHomePage;
import com.orderApp.POM.POM_BillingPage;
import com.orderApp.POM.POM_CartPage;
import com.orderApp.POM.POM_LoginPage;
import com.orderApp.POM.POM_PDPPage;
import com.orderApp.POM.POM_PLPPage;
import com.orderApp.POM.POM_SignIn;

import utils.DriverFactory;

public class PrettyLittleThingPlaceOrder {
	

    WebDriver driver;
    public String url="https://www.prettylittlething.com/";

	
	@BeforeTest
	public void beforeTest() {
	    driver=DriverFactory.getBrowser("chrome");	
	}
	
	@Test
	public void Login() throws IOException, InterruptedException {
		PLTHomePage homePage= new PLTHomePage(driver);
		POM_PLPPage plpPage= new POM_PLPPage(driver);
		POM_PDPPage pdpPage=new POM_PDPPage(driver);
		POM_CartPage cartPage= new POM_CartPage(driver);
		POM_SignIn signInPage= new POM_SignIn(driver);
		POM_BillingPage billingPage= new POM_BillingPage(driver);
		
		homePage.openAndValidateStore(url);
		homePage.selectCategory();
		plpPage.SelectProduct();
		pdpPage.getProductName();
		pdpPage.SelectAndValidateSize();
		pdpPage.addToBag();
		cartPage.ValidateProductName();
		cartPage.getProductPrice();
		cartPage.gotoCheckoutPage();
		signInPage.SignIn();
		billingPage.assertProductName();
		billingPage.assertSelectedProductSize();
		billingPage.assertProductPrice();
		billingPage.verifyDeliveryTotal();
		billingPage.verifyGrandTotal();
		billingPage.clickOnPaymentMethod();
	}
	
	@AfterTest
	public void AfterTest() {
//		driver.quit();
	}

}
