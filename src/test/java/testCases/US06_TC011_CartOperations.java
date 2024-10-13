package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class US06_TC011_CartOperations extends BaseClass {

	@Test(groups = {"Sanity", "Regression", "Cart"})
	public void varify_productAddToCart_US06_TC011() throws InterruptedException 
	{
		logger.info("**** Starting varify_productAddToCart_US06_TC011 ****");

		try {
			HomePage hp = new HomePage(driver);

			hp.searchInput("watch"); // Search for a product by inputting "watch"
			hp.clickSearchIcon(); // Click the search icon
			Thread.sleep(5000);
			SearchResultsPage srp = new SearchResultsPage(driver);

			srp.clickExpectedProduct("Dash Digital Watch"); // Click on the expected product from the search results
			Thread.sleep(5000);
			srp.inputItemQuantity("3"); // Set the quantity of the item
			Thread.sleep(5000);

			srp.clickAddToCart(); // Add the product to the cart
			Thread.sleep(10000);
			srp.clickMyCart(); // Open the shopping cart view

			Thread.sleep(10000);
			srp.clickViewAndEditCart(); // Click on 'View and Edit Cart' to see details
			Thread.sleep(10000);
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			String expProductName = "Dash Digital Watch";

			String cartProductName = scp.getCartItemName(); // Get the actual product name from the cart

			// Assertion to check if the product name matches
			Assert.assertEquals(cartProductName, expProductName, "Item not matched!");
			
		} catch (Exception e) {
			
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("**** Ending varify_productAddToCart_US06_TC011 ****");
	}

	@Test(groups = { "Sanity", "Regression", "Cart" }, dependsOnMethods = { "varify_productAddToCart_US06_TC011" })
	public void varify_updateShoppingCart_US06_TC011() 
	{
		logger.info("**** Starting varify_updateShoppingCart_US06_TC011 ****");

		try {
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			String updateQty = "5";
			scp.setUpdateQty(updateQty); // Set the updated quantity for the product in the cart
			scp.clickUpdateShoppingCart(); // Click to update the shopping cart
			Thread.sleep(3000);
			String actUpdateQty = scp.getUpdatedQty(); // Retrieve the updated quantity from the cart

			// Assert if the updated quantity matches the expected quantity
			Assert.assertEquals(actUpdateQty, updateQty, "Update Qty Mismatch!");
			
		} catch (Exception e) {
			
			Assert.fail("Test failed due to an Exception: " + e.getMessage());
		}

		logger.info("**** Ending varify_updateShoppingCart_US06_TC011 ****");

	}

	@Test(groups = { "Sanity", "Regression", "Cart" }, dependsOnMethods = { "varify_updateShoppingCart_US06_TC011" })
	public void varify_deleteShoppingCart_US06_TC011() 
	{
		logger.info("***** Starting varify_deleteShoppingCart_US06_TC011 *****");
	
		try {
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			Thread.sleep(5000);
			scp.clickRemoveItem(); // Remove the item from the cart
			Thread.sleep(5000);
			String cartEmptyMessage = scp.getCartEmptyMessage();
			String expMessage = "You have no items in your shopping cart.";
			
			//Validate that the cart is empty
			Assert.assertEquals(cartEmptyMessage, expMessage, "Cart is not empty after deletion!");
			
		} catch (Exception e) {
			
			Assert.fail("Test failed due to an Exception: " + e.getMessage());
		}

		logger.info("***** Ending varify_deleteShoppingCart_US06_TC011 *****");
	}

}
