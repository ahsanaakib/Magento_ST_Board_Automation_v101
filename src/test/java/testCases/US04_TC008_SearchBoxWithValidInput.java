package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class US04_TC008_SearchBoxWithValidInput extends BaseClass {

	@Test(groups = {"Sanity", "Regression", "Search"})
	public void varify_searchBoxWithValidInput_US04_TC008() 
	{
		logger.info("***** Starting varify_searchBoxWithValidInput_US04_TC008 ******");

		try {
			HomePage hp = new HomePage(driver);

			hp.searchInput("watch"); //Enter valid search term "watch" into the search box
			hp.clickSearchIcon(); //Click on the search icon to perform the search

			SearchResultsPage srp = new SearchResultsPage(driver);

			String firstResultText = srp.getNameOFFirstProduct(); // Retrieve the name of the first product from the search results
																	
			// Assert that the search result contains the search term "watch"
			Assert.assertTrue(firstResultText.toLowerCase().contains("watch"),
					"Search result does not match the search term");
			
		} catch (Exception e) {
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Ending varify_searchBoxWithValidInput_US04_TC008 ******");
	}
}
