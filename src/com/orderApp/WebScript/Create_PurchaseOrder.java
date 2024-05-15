package com.orderApp.WebScript;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orderApp.POM.POM_Create_PurchaseOrder;
import com.orderApp.POM.POM_LoginPage;
import helpers.ExcelDataProvider;
import utils.DriverFactory;

public class Create_PurchaseOrder {

    WebDriver driver;
    public String url="https://uat-buyer-app.boohoo.com/";
    ExcelDataProvider testData;

	
	@BeforeTest
	public void beforeTest() {
	    driver=DriverFactory.getBrowser("chrome");
		driver.get(url);
		
	}
	
	@DataProvider(name="ordersData")
	public Object[][] getUsers() throws IOException{
		testData= new ExcelDataProvider();
		Object data[][]= testData.getTestData("PurchaseOrderData.xlsx", "Sheet1");
		System.out.println(data);
		return data;
	}
	@Test
	public void Login() throws IOException, InterruptedException {
		POM_LoginPage loginPage= new POM_LoginPage(driver);
		loginPage.SignIn();
	}
	
	@Test(dataProvider= "ordersData",dependsOnMethods= {"Login"})
	public void CreatePO_Order(String Description, String Region,String Supplier, String Factory, String ProductTeam, String ProductGroup, String Style, String Construction, String Composition, String RatioConfig, String colour, String Quantity,String Country, String ExFactoryDate, String EstFactoryDate,String costPrice,String RetailPrice, String FabricComposition, String Attributes) throws InterruptedException, IOException {
		POM_Create_PurchaseOrder createOrderPage= new POM_Create_PurchaseOrder(driver);
		
		createOrderPage.createOrderIcon();
		createOrderPage.EnterOrderDescription(Description);
		createOrderPage.selectRegion(Region);
		createOrderPage.selectSupplier(Supplier);
		createOrderPage.selectFactory(Factory);
		createOrderPage.selectProductTeam(ProductTeam);
		createOrderPage.selectProductGroup(ProductGroup);
		createOrderPage.selectStyle(Style);
		createOrderPage.selectConstruction(Construction);
		createOrderPage.selectPrimaryComposition(Composition);
		createOrderPage.selectSizeConfig(RatioConfig);
		createOrderPage.selectColour(colour);
		createOrderPage.EnterQuantity(Quantity);
		createOrderPage.ConfirmVarients();
		createOrderPage.CountryOfOrigin(Country);
		createOrderPage.EnterExFactoryDate(ExFactoryDate);
		createOrderPage.EnterEstimatedFactoryDate(EstFactoryDate);
		createOrderPage.EnterCostPrice(costPrice);
		createOrderPage.EnterRetailPrice(RetailPrice);
		createOrderPage.CalculateCost();
		createOrderPage.EnterFabricComposition(FabricComposition);
		createOrderPage.selectAttribute(Attributes);
        createOrderPage.SaveDraft();
	}
	
	@AfterTest
	public void AfterTest() {
		driver.quit();
	}
}
