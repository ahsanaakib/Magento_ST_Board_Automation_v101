package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
//	@FindBy(xpath = "")
//	WebElement	;
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement	msgRegSuccess;
	
	public String getRegSuccessMessage()
	{
		try
		{
			waitForElementToBeVisible(msgRegSuccess, 10);
			return msgRegSuccess.getText();
		}catch (Exception e) {
			return "Registration failed or message not found";
		}
	}

}
