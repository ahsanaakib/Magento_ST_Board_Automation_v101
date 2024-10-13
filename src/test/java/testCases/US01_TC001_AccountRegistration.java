package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CustomerAccountPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class US01_TC001_AccountRegistration extends BaseClass {

	@Test(groups = { "Sanity", "Regression", "UserManagement" })
	public void varify_accountRegistration_US01_TC001() 
	{
		logger.info("***** Starting varify_accountRegistration_US01_TC001 *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickCreateAnAcc(); // Navigate to Customer Account Page

			logger.info("Providing Customer details...");

			CustomerAccountPage cap = new CustomerAccountPage(driver);

			cap.setFirstName(randomString().toUpperCase()); // Generating First Name
			cap.setLastName(randomString().toUpperCase()); // Generating Last Name
			cap.setEmailAddress(randomString() + "@gmail.com"); // Generating Email Address

			// Generating and setting Password
			String password = randomAlphanumericString(); 

			cap.setPassword(password);
			cap.setConfirmPassword(password);
			Thread.sleep(2000);
			cap.clickBtnCreateAccount(); // click Create an Account button to submit form

			logger.info("Validating Registration Successful Message.");

			// Validate the success message after account creation
			MyAccountPage map = new MyAccountPage(driver);
			String regSuccMsg = map.getRegSuccessMessage(); // Navigate to My Account Page and get Registration Success
															// Message

			// Check if the registration success message is as expected
			if (regSuccMsg.equals("Thank you for registering with Main Website Store.")) 
			{
				Assert.assertTrue(true); // Test passes if success message is correct
			} 
			else 
			{
				logger.error("Test failed...");
				Assert.assertTrue(false); // Test fails if the success message is incorrect
			}
		} catch (Exception e) {
			Assert.fail("Test failed due to an Exception: " + e.getMessage()); // Fail the test if an exception occurs
		}

		logger.info("***** Ending varify_accountRegistration_US01_TC001 *****");
	}
}
