package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageHeroHoodie extends BasePage{

	public ProductDetailsPageHeroHoodie(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='option-label-size-143-item-169']")
	WebElement productSizeL;
	
	@FindBy(xpath = "//div[@id='option-label-color-93-item-53']")
	WebElement productColorGreen;
	
	@FindBy(xpath = "//input[@id='qty']")
	WebElement inputQty;
	
	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	WebElement btnAddToCart;
	
	public void selectProductSize()
	{
		waitForElementToBeClickable(productSizeL, 10);
		productSizeL.click();
	}
	public void selectColor()
	{
		waitForElementToBeClickable(productColorGreen, 10);
		productColorGreen.click();
	}
	public void inputQuantity(String qty)
	{
		waitForElementToBeClickable(inputQty, 10);
		inputQty.click();
		inputQty.clear();
		inputQty.sendKeys(qty);
	}
	public void clickAddToCart()
	{
		waitForElementToBeClickable(btnAddToCart, 10);
		btnAddToCart.click();
	}

}
