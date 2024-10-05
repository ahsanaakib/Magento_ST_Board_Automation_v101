package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListingPage extends BasePage {

	public ProductListingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='page-wrapper']//div[2]//div[3]//select[1]")
	WebElement	sortByDropdown;			//sort by drop down web element
	
	@FindBy(xpath = "//div[@class='page-wrapper']//div[2]//div[3]//select[1]//option[3]")
	WebElement sortByPrice;	//select sort by price from drop down
	
	@FindBy(xpath = "//div[@class='column main']//div[2]//div[3]//a[1]")
	WebElement setDescDir;	//set price descending direction web element
	
	public void clickSortByDropDown()
	{
		waitForElementToBeClickable(sortByDropdown, 10);
		sortByDropdown.click();		//click sort by drop down
	}
	
	public void selectSortByPrice()
	{
		waitForElementToBeClickable(sortByPrice, 10);
		sortByPrice.click();		//select sort by price
	}
	public void clickSetDescDir()
	{	
		setDescDir.click();		//set descending direction
	}
}
