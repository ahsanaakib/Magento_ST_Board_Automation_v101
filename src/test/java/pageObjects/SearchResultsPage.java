package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Didi Sport Watch']")
	WebElement firstResultItem;
	
	@FindBy(xpath = "//img[@alt='Dash Digital Watch']")
	WebElement dashDigitalWatch;
	
	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement myCartElement;
	
	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	WebElement btnAddToCartElement;
	
	@FindBy(xpath="//a[@class='action viewcart']/span")
	WebElement viewAndEditCartElement;
	
	@FindBy(xpath = "//input[@class='input-text qty']")
	WebElement itemQtyElement;
	
	@FindBy(xpath = "//button[@class='update-cart-item']")
	WebElement btnUpdateQtyItemElement;
	
	public String getNameOFFirstProduct()
	{
		try
		{
		waitForElementToBeVisible(firstResultItem, 20);
		return firstResultItem.getText();
		}catch (Exception e) {
			return "Search item not found";
		}
	}
	public void clickExpectedProduct(String productName)
	{
		try
		{
		WebElement productElement= driver.findElement(By.xpath("//img[@alt='" + productName + "']"));
		productElement.click();
		}catch (NoSuchElementException e) {
	        Assert.fail("Unable to find product.");
		}
		
	}
	public void clickMyCart()
	{
		myCartElement.click();
	}
	public void inputItemQuantity(String qty)
	{
		itemQtyElement.clear();
		itemQtyElement.sendKeys(qty);
	}
	
	public void clickAddToCart()
	{
		btnAddToCartElement.click();
	}
	public void clickUpdateQty()
	{
		btnUpdateQtyItemElement.click();
	}
	
	public void clickViewAndEditCart()
	{
		viewAndEditCartElement.click();
	}
}
