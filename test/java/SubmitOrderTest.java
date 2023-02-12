import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage;
import pageObjects.ProductCatlaogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		  String baseURL = "https://rahulshettyacademy.com/client/";
		  WebDriver driver = new ChromeDriver();
		  driver.get(baseURL);
		  LoginPage loginPage = new LoginPage(driver);
		  loginPage.clickLogin("dasari.jayalakshmi17@gmail.com", "JayalakshmiTest123");
		  
		    //14. wait until you get success message 
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products")));

		  
		   ProductCatlaogue productsPage = new ProductCatlaogue(driver);
		   
		   List<WebElement> productsList = productsPage.getProductsList();
		   
		   System.out.println(productsList.size());
		   
		   productsPage.addProductToCart("ADIDAS ORIGINAL");
		   productsPage.addProductToCart("ZARA COAT 3");

		 
	}

}
