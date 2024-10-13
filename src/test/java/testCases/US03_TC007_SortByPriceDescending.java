package testCases;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.WatchesPage;
import testBase.BaseClass;

public class US03_TC007_SortByPriceDescending extends BaseClass {

	@Test(groups = {"Regression","UI"})
	public void varify_SortByPriceAscending_Watches_US03_TC007() 
	{
		logger.info("***** Starting varify_SortByPriceAscending_Watches_US03_TC007 *****");

		try {
			HomePage hp = new HomePage(driver);

			hp.hoverOverElement(hp.getMainMenuElement("gear")); // Perform mouse hover action on the 'gear' main menu
			WebElement watchesSubMenu = hp.getSubMenuOption("watches"); // get 'watches' sub menu web element
			watchesSubMenu.click(); // Navigate to watches page

			WatchesPage wp = new WatchesPage(driver);

			wp.clickSortByDropDown(); // Click Sort By drop down
			wp.selectSortByPrice(); // Select sort by price
			wp.clickSetDescDir(); // Set the sort direction to descending
			Thread.sleep(5000);
			// Retrieve the list of product prices displayed on the page
			List<Double> displayedPrices = wp.getProductPrices();
			
			// Sort the list of product prices in descending order for comparison
			List<Double> sortedPrices = displayedPrices.stream()
					.sorted((p1, p2) -> Double.compare(p2, p1)) 
					.collect(Collectors.toList());
			Thread.sleep(5000);
			
			// Validation: Compare the displayed prices with the sorted prices in descending order
			Assert.assertEquals(displayedPrices, sortedPrices, "Products are not sorted by price in descending order!");
			
		} catch (Exception e) {
			logger.error(
					"An error occurred while verifying the sorting of prices in descending order: " + e.getMessage());
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Finished varify_SortByPriceAscending_Watches_US03_TC007 *****");
	}
}
