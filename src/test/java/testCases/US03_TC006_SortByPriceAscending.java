package testCases;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.WatchesPage;
import testBase.BaseClass;

public class US03_TC006_SortByPriceAscending extends BaseClass {

	@Test(groups = {"Sanity","UI","Regression"})
	public void varify_SortByPriceAscending_Watches_US03_TC006() 
	{	
		logger.info("***** Starting varify_SortByPriceAscending_Watches_US03_TC006 *****");

		try {
			HomePage hp = new HomePage(driver);

			hp.hoverOverElement(hp.getMainMenuElement("gear")); // Mouse hover on Gear menu
			WebElement watchesSubMenu = hp.getSubMenuOption("watches"); // get 'watches' sub menu web element
			watchesSubMenu.click(); // Navigate to watches page

			WatchesPage wp = new WatchesPage(driver);

			wp.clickSortByDropDown(); // Click on the "Sort By" drop-down
			wp.selectSortByPrice(); // Select sort by price
			Thread.sleep(3000);
			
			// Retrieve the list of product prices displayed on the page
			List<Double> displayedPrices = wp.getProductPrices();
			
			// Sort the list of product prices in ascending order for comparison
			List<Double> sortedPrices = displayedPrices.stream().sorted().collect(Collectors.toList());
			
			// Validation: Compare the displayed prices with the sorted prices
			Assert.assertEquals(displayedPrices, sortedPrices, "Products are not sorted by price in ascending order!");
			
		} catch (Exception e) {
			logger.error(
					"An error occurred while verifying the sorting of prices in ascending order: " + e.getMessage());
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}

		logger.info("***** Ending varify_SortByPriceAscending_Watches_US03_TC006 *****");
	}
}
