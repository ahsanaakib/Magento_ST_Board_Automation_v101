package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerAccountPage extends BasePage {

	public CustomerAccountPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "")
//	WebElement	;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement	txtLastName;
	
	@FindBy(xpath = "//input[@id='email_address']")
	WebElement	txtEmailAddress;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement	txtPassword;
	
	@FindBy(xpath = "//input[@id='password-confirmation']")
	WebElement	txtConfirmPassword;
	
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement	btnCreateAnAcc;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String  lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void setEmailAddress(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String cpwd)
	{
		txtConfirmPassword.sendKeys(cpwd);
	}
	public void clickBtnCreateAccount()
	{
		btnCreateAnAcc.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
