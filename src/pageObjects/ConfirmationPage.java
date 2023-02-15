package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	public ConfirmationPage(WebDriver driverObject) {
		super(driverObject);
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//h1[normalize-space()='Thankyou for the order.']")
	WebElement confirmationMessage;

	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}

}
