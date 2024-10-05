package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WatchesPage extends ProductListingPage{

	public WatchesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='price-box price-final_price']//span[@class='price']")
	List<WebElement> productPriceElements;
	
	public List<Double> getProductPrices()
	{
		return productPriceElements.stream()
        .map(e -> Double.parseDouble(e.getText().replace("$", "").trim())) // Parse prices to Double
        .collect(Collectors.toList());
	}
}
