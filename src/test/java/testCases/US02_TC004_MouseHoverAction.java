package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class US02_TC004_MouseHoverAction extends BaseClass {

	@Test(groups = { "Regression", "UI" })
	public void varify_mouseHoverAction_US02_TC004() throws InterruptedException 
	{
		logger.info("***** Starting varify_mouseHoverAction_US02_TC004 *****");

		try {
			HomePage hp = new HomePage(driver);

			String colorBeforeHover = hp.getTextColor(); // Capture the color of the text before hovering over the menu item

			hp.hoverOverElement(hp.getMainMenuElement("gear")); // Perform mouse hover action on the specified main menu element (gear menu)

			String colorAfterHover = hp.getTextColor(); // Capture the color of the text after hovering

			logger.info("Color before hover: " + colorBeforeHover);
			logger.info("Color after hover: " + colorAfterHover);

			String expectedColorBeforeHover = "rgba(87, 87, 87, 1)"; // Define the expected color before hovering

			// Validate the color before hover matches the expected color
			Assert.assertEquals(colorBeforeHover, expectedColorBeforeHover,
					"Text color before hover is not as expected");

			String expectedColorAfterHover = "rgba(51, 51, 51, 1)"; // Expected color after hovering

			// Validate the color after hover matches the expected color
			Assert.assertEquals(colorAfterHover, expectedColorAfterHover, "Text color after hover is not as expected");

		} catch (Exception e) {
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}

		logger.info("***** Ending varify_mouseHoverAction_US02_TC004 *****");

	}
}
