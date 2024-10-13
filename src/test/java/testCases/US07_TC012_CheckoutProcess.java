package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPageHeroHoodie;
import pageObjects.SearchResultsPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SuccessPage;
import testBase.BaseClass;

public class US07_TC012_CheckoutProcess extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "Cart","Checkout" })
	public void varify_checkoutProcess_US07_TC012() throws InterruptedException 
	{
		logger.info("**** Starting varify_checkoutProcess_US07_TC012 ****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickSignIn(); // Navigate to Login Page

			LoginPage lp = new LoginPage(driver);
			lp.sendEmail(p.getProperty("email")); // Input email
			lp.sendPassword(p.getProperty("password")); // Input Password
			lp.clickSignIn(); // Click Sign in button

			hp.searchInput("hero hoodie"); // Search for 'hero hoodie' product
			hp.clickSearchIcon(); // Click Search Icon

			SearchResultsPage srp = new SearchResultsPage(driver);
			Thread.sleep(5000);
			srp.clickHeroHoodie(); //if clickExpectedProduct not work
			//srp.clickExpectedProduct("Hero Hoodie"); // click 'hero hoodie' as expected product
			Thread.sleep(5000);
			ProductDetailsPageHeroHoodie pdp = new ProductDetailsPageHeroHoodie(driver);
			pdp.selectProductSize(); // Select Product Size
			Thread.sleep(5000);
			pdp.selectColor();
			Thread.sleep(5000);
			pdp.inputQuantity("5"); // Select Product Color
			Thread.sleep(5000);
			pdp.clickAddToCart(); // Click Add to Cart

			Thread.sleep(5000);
			srp.clickMyCart();
			Thread.sleep(10000);
			srp.clickViewAndEditCart(); // Navigate to Shopping Cart Page
			Thread.sleep(10000);

			ShoppingCartPage scp = new ShoppingCartPage(driver);
			scp.clickProceedToCheckout();
			Thread.sleep(5000);
			CheckoutPage cp = new CheckoutPage(driver);
			
			
			cp.clickNext();
			
			Thread.sleep(5000);
			cp.clickPlaceOrder();	// Click place order
			Thread.sleep(5000);

			SuccessPage sp = new SuccessPage(driver);
			String actualMsg = sp.getPurchaseSuccessMessage();
			String expMsg = "Thank you for your purchase!";
			
			//Assertion to check if the Purchase Successful Message match
			Assert.assertEquals(actualMsg, expMsg, "Message not match!");
		} catch (Exception e) {
			Assert.fail("Test failed due to an Exception" + e.getMessage());
		}
		logger.info("**** Ending varify_checkoutProcess_US07_TC012 ****");

	}
}
