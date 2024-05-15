package com.orderApp.POM;

import static utils.ReadCredsProperty.getSelector;
import static utils.ReadCredsProperty.getUserCredentials;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_Create_PurchaseOrder {

	WebDriver driver;

	public POM_Create_PurchaseOrder(WebDriver driver) {
		this.driver = driver;

	}

	public void waitForElementDisplayed(By Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element)).isDisplayed();
	}
	
	public void createOrderIcon() throws IOException {
		driver.findElement(getSelector("createOrder")).click();				
	}
	
	public void EnterOrderDescription(String description) throws IOException {
		driver.findElement(getSelector("Orderdescription")).clear();
		driver.findElement(getSelector("Orderdescription")).sendKeys(description);	
	}
	
	public void selectRegion(String Region) throws InterruptedException, IOException {
		By locator=getSelector("region");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+Region+"')]");
		common_OrderPageSelector(locator, xpathlocator);	
	}
	
	public void selectSupplier(String Supplier) throws InterruptedException, IOException {
		By locator=getSelector("supplier");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+Supplier+"')]");
		common_OrderPageSelector(locator, xpathlocator);
		Thread.sleep(1000);
	}
	
	public void selectFactory(String Factory) throws InterruptedException, IOException {
		By locator=getSelector("factory");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+Factory+"')]");
		common_OrderPageSelector(locator, xpathlocator);	
	}
	
	public void selectProductTeam(String ProductTeam) throws InterruptedException, IOException {
		By locator=getSelector("productTeam");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+ProductTeam+"')]");
		common_OrderPageSelector(locator, xpathlocator);		
	}
	
	public void selectProductGroup(String ProductGroup) throws InterruptedException, IOException {
		By locator=getSelector("productGroup");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+ProductGroup+"')]");
		common_OrderPageSelector(locator, xpathlocator);
	}
	
	public void selectStyle(String Style) throws InterruptedException, IOException {
		By locator=getSelector("style");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+Style+"')]");
		common_OrderPageSelector(locator, xpathlocator);
	}
	
	public void selectConstruction(String Construction) throws InterruptedException, IOException {
		By locator=getSelector("construction");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+Construction+"')]");
		common_OrderPageSelector(locator, xpathlocator);	
	}
	
	public void selectPrimaryComposition(String Composition) throws InterruptedException, IOException {
		By locator=getSelector("primarycomposition_clothing");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+Composition+"')]");
		common_OrderPageSelector(locator, xpathlocator);	
	}
	
	public void selectSizeConfig(String SizeConfig) throws InterruptedException, IOException {
		By locator=getSelector("sizeConfig");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+SizeConfig+"')]");
		common_OrderPageSelector(locator, xpathlocator);
	}
	
	public void selectColour(String colour) throws InterruptedException, IOException {
		By locator=getSelector("colour");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+colour+"')]");
		common_OrderPageSelector(locator, xpathlocator);
	}
	
	public void EnterQuantity(String Quantity) throws IOException {
		driver.findElement(getSelector("quantity")).clear();
		driver.findElement(getSelector("quantity")).sendKeys("value", Quantity);
		driver.findElement(getSelector("quantity")).sendKeys(Keys.BACK_SPACE);
	}
	
	
	public void ConfirmVarients() throws IOException {
		driver.findElement(getSelector("varient")).click();
		
	}
	
	public void CountryOfOrigin(String country) throws InterruptedException, IOException {
		By locator=getSelector("freightCountry");
		By xpathlocator=By.xpath("//ul//li[contains(.,'"+country+"')]");
		common_OrderPageSelector(locator, xpathlocator);
	}
	
	public void EnterExFactoryDate(String ExFactoryDate) throws IOException {
		driver.findElement(getSelector("exFactoryDate")).clear();
		driver.findElement(getSelector("exFactoryDate")).sendKeys(ExFactoryDate);	
	}
	
	public void EnterEstimatedFactoryDate(String EstimateFactoryDate) throws IOException {
		driver.findElement(getSelector("EstFactoryDate")).clear();
		driver.findElement(getSelector("EstFactoryDate")).sendKeys(EstimateFactoryDate);	
	}
	
	public void EnterCostPrice(String costPrice) throws InterruptedException, IOException {
		driver.findElement(getSelector("costPrice")).clear();	
		driver.findElement(getSelector("costPrice")).sendKeys(costPrice);	
		driver.findElement(getSelector("costPrice")).sendKeys(Keys.BACK_SPACE);
	}
	
	public void EnterRetailPrice(String retailPrice) throws IOException {
		driver.findElement(getSelector("retailPrice")).clear();
		driver.findElement(getSelector("retailPrice")).sendKeys(retailPrice);
		driver.findElement(getSelector("retailPrice")).sendKeys(Keys.BACK_SPACE);
	}
	
	public void CalculateCost() throws InterruptedException, IOException {
		WebElement l=driver.findElement(getSelector("callculateCost"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
		driver.findElement(getSelector("callculateCost")).click();
		Thread.sleep(5000);
	}
	
	public void EnterFabricComposition(String fabricComposition) throws InterruptedException, IOException {
		driver.findElement(getSelector("fabricComposition")).sendKeys(fabricComposition);
		
	}
	
	public void selectAttribute(String Attributes) throws InterruptedException, IOException {
		By locator=getSelector("attributesTab");
		By xpathlocator=By.xpath("//span[contains(.,'"+Attributes+"')]");
		
		selectMultipleAttributes(locator);
		Thread.sleep(3000);
		selectMultipleAttributes(By.xpath("//span[contains(.,'"+Attributes+"')]"));
		selectMultipleAttributes(getSelector("gender"));
		selectMultipleAttributes(getSelector("season"));
		selectMultipleAttributes(getSelector("furRisk"));
		selectMultipleAttributes(getSelector("propRisk"));
	}
	
	public void SaveDraft() throws IOException, InterruptedException {
		driver.findElement(getSelector("saveDraft")).click();
		Thread.sleep(3000);
	}
	
	public void common_OrderPageSelector(By locator,By xpathlocator) throws InterruptedException {
		Thread.sleep(1000);
		WebElement l=driver.findElement(locator);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
		driver.findElement(locator).click();
		driver.findElement(xpathlocator).click();	
	}
	
	public void selectMultipleAttributes(By  locator) throws InterruptedException {
		WebElement l=driver.findElement(locator);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
		waitForElementDisplayed(locator);
		driver.findElement(locator).click();	
	}
}
