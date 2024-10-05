package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class US04_TC009_SearchBoxWithAnEmptyInput extends BaseClass {

	@Test(groups = { "Regression", "Search" })
	public void varify_searchBoxWithEmptyInput_US04_TC009() 
	{
		logger.info("***** Starting varify_searchBoxWithEmptyInput_US04_TC009 *****");
		
		try 
		{
			HomePage hp = new HomePage(driver);

			hp.searchInput(""); // Enter an empty string into the search input field

			// Verify if the search icon is clickable when input is empty
			boolean isSearchIconClickable = hp.isSearchIconClickable();

			// Assert that the search icon should not be clickable for an empty input
			Assert.assertFalse(isSearchIconClickable, "Search icon should not be displayed for empty input.");

		} catch (Exception e) {
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending varify_searchBoxWithEmptyInput_US04_TC009 *****");
	}
}
