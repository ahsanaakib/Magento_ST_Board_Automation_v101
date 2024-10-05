package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class US01_TC003_InvalidUserLogin extends BaseClass {

	@Test(groups = { "Regression", "UserManagement" })
	public void varify_invalidUserLogin_US01_TC003() 
	{
		try {
			logger.info("**** Starting varify_invalidUserLogin_US01_TC003 ****");

			HomePage hp = new HomePage(driver);
			hp.clickSignIn(); // Navigate to Login Page

			LoginPage lp = new LoginPage(driver);

			lp.sendEmail(p.getProperty("email")); // sending user email
			lp.sendPassword(p.getProperty("wrongpassword")); // sending wrong password
			lp.clickSignIn(); // click sign in button

			String loginErrMsg = lp.getloginErrorMessage(); // get login error message

			logger.info("Validating Loging Error Message");

			Assert.assertTrue(loginErrMsg.contains(
					"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."),
					"Expected error message not found for invalid credentials");

		} catch (Exception e) {
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("**** Ending varify_invalidUserLogin_US01_TC003 ****");

	}

}
