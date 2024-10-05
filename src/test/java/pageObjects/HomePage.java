package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='logo']")
	WebElement logoLuma;

	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement lnkCreateAnAcc; // create an account web element

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement lnkSignIn; // Sign In web element

	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, demo demo!']")
	WebElement userWelcomeMsg; // user welcome message web element

	@FindBy(xpath = "//a[@id='ui-id-6']")
	WebElement drpdwnGear; // drop down of Gear web element

	@FindBy(xpath = "//a[@id='ui-id-27']")
	WebElement gearSubMenu_Watches; // watches sub menu of Gear

	@FindBy(xpath = "//a[@id='ui-id-5']")
	WebElement drpdwnMen; // drop down of Men web element

	@FindBy(xpath = "//a[@id='ui-id-17']")
	WebElement menSubMenu_Tops; // tops sub menu of Men

	@FindBy(xpath = "//a[@id='ui-id-20']")
	WebElement topsLeafMenu_HoodAndSweat; // Hoodies and Sweatshirts leaf menu of tops

	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBar; // search bar Web Element

	@FindBy(xpath = "//button[@class='action search']")
	WebElement searchIcon; // search icon in search bar

	public void clickCreateAnAcc() {
		lnkCreateAnAcc.click(); // click create an account link
	}

	public void clickSignIn() {
		lnkSignIn.click(); // click on sign in link
	}

	public void logoLuma() {
		logoLuma.click(); // click on logo LUMA
	}

	public void hoverOverElement(WebElement menuElement) {
		Actions act = new Actions(driver);
		act.moveToElement(menuElement).perform(); // Mouse hover actions
	}

	public void searchInput(String searchText) {
		waitForElementToBeVisible(searchBar, 10);
		searchBar.clear();
		searchBar.sendKeys(searchText); // input text in search bar
	}

	public boolean isSearchIconClickable() {
		try {
			return searchIcon.isEnabled() && searchIcon.isDisplayed(); // Check if the element is both displayed and
																		// enabled
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickSearchIcon() {
		searchIcon.click();
	}

	public String getUserWelcomeMessage() {
		try {
			return userWelcomeMsg.getText(); // return user welcome message
		} catch (Exception e) {
			return "Welcome message not found";
		}
	}

	public String getTextColor() {
		return drpdwnGear.getCssValue("color"); // return Gear menu color
	}

	// get all the menu web element
	public WebElement getMainMenuElement(String menuName) {
		switch (menuName.toLowerCase()) {
		case "gear":
			return drpdwnGear;
		case "men":
			return drpdwnMen;

		default:
			throw new IllegalArgumentException("Invalid menu name: " + menuName);

		}
	}

	// get all the sub menu web element
	public WebElement getSubMenuOption(String subMenuName) {
		switch (subMenuName.toLowerCase()) {
		case "watches":
			return gearSubMenu_Watches;
		case "tops":
			return menSubMenu_Tops;
		default:
			throw new IllegalArgumentException("Invalid sub menu name: " + subMenuName);

		}
	}

	// get all the child menu web element
	public WebElement getLeafMenuOption(String leafMenuName) {
		switch (leafMenuName.toLowerCase()) {
		case "hoodies and sweatshirts":
			return topsLeafMenu_HoodAndSweat;

		default:
			throw new IllegalArgumentException("Invalid child menu name: " + leafMenuName);

		}
	}

}
