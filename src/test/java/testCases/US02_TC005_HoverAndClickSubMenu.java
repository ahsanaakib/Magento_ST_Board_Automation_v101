package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class US02_TC005_HoverAndClickSubMenu extends BaseClass {

	@Test(groups = { "Sanity", "UI", "Regression" })
	public void varify_HoverAndClickSubMenu_US02_TC005() throws InterruptedException 
	{
		try {
			logger.info("**** Starting varify_HoverAndClickSubMenu_US02_TC005 ****");

			HomePage hp = new HomePage(driver);

			hp.hoverOverElement(hp.getMainMenuElement("gear")); // Perform hover action on the 'gear' main menu
			WebElement watchesSubMenu = hp.getSubMenuOption("watches"); // Get watches sub menu web element
			watchesSubMenu.click(); // Click watches sub menu item

			// Validation: Check if the URL is correct after clicking the sub menu
			String expURL = "https://magento.softwaretestingboard.com/gear/watches.html"; // expected URL of watches page
																							
			String actURL = driver.getCurrentUrl(); // get current URL after clicking watches

			logger.info("Actual URL of watches page: " + actURL);

			// Assert to verify the actual URL matches the expected URL
			Assert.assertEquals(actURL, expURL, "The URL after clicking 'Watches' submenu is incorrect!");
		} catch (Exception e) {

			Assert.fail("Test failed due to an Exception: " + e.getMessage());
		}

		logger.info("**** Ending varify_HoverAndClickSubMenu_US02_TC005 ****");
	}
}
