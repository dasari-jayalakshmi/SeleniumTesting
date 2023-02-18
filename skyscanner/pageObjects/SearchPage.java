package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponentSS;

public class SearchPage extends AbstractComponentSS {
	WebDriver driver;
	public SearchPage(WebDriver driverObject) {
		super(driverObject);
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Search flights']")
	WebElement headerMessage;
	
	@FindBy(xpath = "//button[@aria-label='Leaving from']")
	WebElement fromButton;
	
	@FindBy(xpath = "//button[@aria-label='Going to']")
	WebElement toButton;
	
	@FindBy(xpath="//input[@id='location-field-leg1-origin']")
	WebElement fromInput;
	
	By fromList = By.xpath("//div[@class='uitk-spacing uitk-typeahead-results uitk-spacing-padding-blockstart-three']");

	@FindBy(xpath="//button[@aria-label='Sydney (SYD - Kingsford Smith Intl.) New South Wales, Australia']")
	WebElement fromLocationButton;
	
	public String getHeaderMessage() {
		return headerMessage.getText();
	}
	
	public void selectFromLocation(String fromLocation) {
		fromButton.click();
		fromInput.sendKeys(fromLocation);
		waitForElementToAppear(fromList);
		fromLocationButton.click();
	}

}
