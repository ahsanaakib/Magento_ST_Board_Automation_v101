package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.HoodieAndSweatshirtsPage;
import testBase.BaseClass;

public class US05_TC010_TertiaryMenuNavigation extends BaseClass {

	@Test(groups= {"UI","Sanity","Regression"})
	public void varify_tertiaryMenuNavigation_US05_TC010() 
	{
		logger.info("***** Starting varify_tertiaryMenuNavigation_US05_TC010 *****");
		try {
			HomePage hp = new HomePage(driver);

			hp.hoverOverElement(hp.getMainMenuElement("men")); //Hover over the 'Men' menu to display the sub-menus			

			hp.hoverOverElement(hp.getSubMenuOption("tops")); //Hover over the 'Tops' sub-menu to display leaf options
			
			//Get the 'Hoodies & Sweatshirts' leaf option and click it
			WebElement hoodiesAndSweatshirtsOption = hp.getLeafMenuOption("hoodies and sweatshirts");
			hoodiesAndSweatshirtsOption.click();

			// Validate navigation to the Hoodies & Sweatshirts page
			HoodieAndSweatshirtsPage hasp= new HoodieAndSweatshirtsPage(driver);
			String pageHeading=hasp.getPageHeading();
			
			// Assert that the page heading matches the expected value
			Assert.assertEquals(pageHeading, "Hoodies & Sweatshirts", "Heading not matched!");
			
		} catch (Exception e) {
			logger.error("An error occurred while verifying tertiaryMenuNavigation: " + e.getMessage());
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending varify_tertiaryMenuNavigation_US05_TC010 *****");
	}
}
