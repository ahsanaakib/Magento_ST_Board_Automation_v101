package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class US01_TC002_ValidUserLogin extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "UserManagement" })
	public void varify_validUserLogin_US01_TC002() 
	{
		try {
			logger.info("**** Starting varify_validUserLogin_US01_TC002 ****");

			HomePage hp = new HomePage(driver);
			hp.clickSignIn(); // Navigate to Login Page

			LoginPage lp = new LoginPage(driver);

			lp.sendEmail(p.getProperty("email")); // sending user email
			lp.sendPassword(p.getProperty("password")); // sending user password
			lp.clickSignIn(); // click sign in button
			Thread.sleep(3000);

			logger.info("Validating User Welcome Message");

			String userwelcomemsg = hp.getUserWelcomeMessage(); // capture user welcome message		

			Assert.assertTrue(userwelcomemsg.contains("Welcome"), // user welcome message should contains 'Welcome fname lname'
					"Welcome Message not matched");

		} catch (Exception e) {
			Assert.fail("Test failed due to an Exception: "+e.getMessage());
		}
		logger.info("**** Ending varify_validUserLogin_US01_TC002 ****");
	}
}
