package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Dash Digital Watch']")
	WebElement cartItemNameElement;
	
	@FindBy(xpath = "//input[@title='Qty']")
	WebElement inputUpdateQty;
	
	@FindBy(xpath = "//button[@title='Update Shopping Cart']")
	WebElement btnUpdateShoppingCart;
	
	@FindBy(xpath = "//a[@class='action action-delete']")
	WebElement lnkRemoveItem;
	
	@FindBy(xpath = "//div[@class='cart-empty']/p[1]")
	WebElement txtCartEmptyMessage;
	
	@FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
	WebElement btnProceedToCheckout;
	
	public String getCartItemName()
	{
		waitForElementToBeVisible(cartItemNameElement, 10);
		return cartItemNameElement.getText();
	}

	public void setUpdateQty(String updateQty)
	{
		inputUpdateQty.clear();
		inputUpdateQty.sendKeys(updateQty);
	}
	public void clickUpdateShoppingCart()
	{
		waitForElementToBeClickable(btnUpdateShoppingCart, 10);
		btnUpdateShoppingCart.click();
	}
	public String getUpdatedQty()
	{
		return inputUpdateQty.getAttribute("value");
	}
	public void clickRemoveItem()
	{
		waitForElementToBeClickable(lnkRemoveItem, 10);
		lnkRemoveItem.click();
	}
	public String getCartEmptyMessage()
	{
		try
		{
		return txtCartEmptyMessage.getText();
		}catch (Exception e) {
			return "Cart empty message not found";
		}
	}
	public void clickProceedToCheckout()
	{
		waitForElementToBeClickable(btnProceedToCheckout, 10);
		btnProceedToCheckout.click();
	}
	
}
