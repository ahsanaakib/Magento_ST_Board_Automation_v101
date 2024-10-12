package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@data-role='opc-continue']")
	WebElement btnNext;
	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement btnPlaceOrder;
	
	public void clickNext()
	{
		waitForElementToBeClickable(btnNext, 10);
		btnNext.click();
	}
	public void clickPlaceOrder()
	{
		waitForElementToBeClickable(btnPlaceOrder, 10);
		btnPlaceOrder.click();
	}
}
