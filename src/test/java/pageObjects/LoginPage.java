package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;	//email web element
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement txtPassword;	//password web element
	
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement btnSignIn;	//sign in button web element
	
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement txtLoginErrorMsg;	//login error message web element
	
	public void sendEmail(String email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);	//provide user email
	}
	public void sendPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);	//provide user password
	}
	public void clickSignIn()
	{
		btnSignIn.click();			//click sign in button
	}
	public String getloginErrorMessage()
	{
		waitForElementToBeVisible(txtLoginErrorMsg, 10);
		try
		{
		return txtLoginErrorMsg.getText();		//return login error message
		}catch (Exception e) {
			return "Login error";
		}
	}
	
	
}
