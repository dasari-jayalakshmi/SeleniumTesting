package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponent;

public class ProductCatlaogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatlaogue(WebDriver driverObject) {
		super(driverObject);
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//body/app-root[1]/app-dashboard[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]")
	WebElement addToCartCoat;

	@FindBy(xpath = "//body/app-root[1]/app-dashboard[1]/section[2]/div[1]/div[2]/div[2]/div[1]/div[1]/button[2]")
	WebElement addToCartAddidas;

	@FindBy(xpath = "//body/app-root[1]/app-profile[1]/app-sidebar[1]/nav[1]/ul[1]/li[4]/button[1]")
	WebElement viewCart;

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement filteredProduct = getProductsList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return filteredProduct;

	}

	public void addProductToCart(String productName) {
		WebElement product = getProductByName(productName);
		product.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDissappear(spinner);

	}

	public void viewCart(WebDriverWait wait) {
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//body/app-root[1]/app-dashboard[1]/app-sidebar[1]/nav[1]/ul[1]/li[4]/button[1]/i[1]")));
		cart.click();
	}

	public WebElement getViewCartElement() {
		return viewCart;
	}
}
