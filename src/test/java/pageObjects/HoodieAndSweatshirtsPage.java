package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoodieAndSweatshirtsPage extends BasePage{

	public HoodieAndSweatshirtsPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(xpath = "//span[@class='base']")
	WebElement headingHoodieAndSweatshirts;
	
	public String  getPageHeading()
	{
		return headingHoodieAndSweatshirts.getText();
	}
}
