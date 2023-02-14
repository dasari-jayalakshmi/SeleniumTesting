import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductCatlaogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		String baseURL = "https://rahulshettyacademy.com/client/";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		ProductCatlaogue productsPage = loginPage.clickLogin("dasari.jayalakshmi17@gmail.com", "JayalakshmiTest123");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products")));
		String productName = "ADIDAS ORIGINAL";
		List<WebElement> productsList = productsPage.getProductsList();
		productsPage.addProductToCart(productName);
		CartPage cartPage = productsPage.gotoCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		cartPage.checkOut();
	}

}
