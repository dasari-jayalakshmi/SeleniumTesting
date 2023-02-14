package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;

	public CartPage(WebDriver driverObject) {
		super(driverObject);
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = productTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public void checkOut() {
		checkOutEle.click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
