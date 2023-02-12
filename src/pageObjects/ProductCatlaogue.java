package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCatlaogue {
	 WebDriver driver;

	public ProductCatlaogue(WebDriver driverObject){
		this.driver = driverObject;
		PageFactory.initElements(driverObject, this);
	}
	
	@FindBy(xpath="//body/app-root[1]/app-dashboard[1]/section[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]")
	WebElement addToCartCoat;
	
	@FindBy(xpath="//body/app-root[1]/app-dashboard[1]/section[2]/div[1]/div[2]/div[2]/div[1]/div[1]/button[2]")
	WebElement addToCartAddidas;
	
	@FindBy(xpath="//body/app-root[1]/app-profile[1]/app-sidebar[1]/nav[1]/ul[1]/li[4]/button[1]")
	WebElement viewCart;
	
	
	
	//Actions:
	public void selectCoat(){
		addToCartCoat.click();
	}
	
	public void selectAddidasShoe(){
		addToCartAddidas.click();
	}
	
	public boolean validateCoat(){
		return addToCartCoat.isDisplayed();
	}
	
	public void viewCart(WebDriverWait wait){
		   WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/app-dashboard[1]/app-sidebar[1]/nav[1]/ul[1]/li[4]/button[1]/i[1]")));
		   cart.click();
	}
	
	public WebElement getViewCartElement() {
		return viewCart;
	}
}
