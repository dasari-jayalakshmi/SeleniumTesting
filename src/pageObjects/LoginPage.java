package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver driver;
	 
	//Initializing the Page Objects:
		public LoginPage(WebDriver driverObject){
			this.driver = driverObject;
			PageFactory.initElements(driverObject, this);
		}
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement userPassword;
		
		@FindBy(id="login")
		WebElement login;
		
		
		//Actions:
		public void clickLogin(String email, String password){
			userEmail.sendKeys(email);
			userPassword.sendKeys(password);
			login.click();
		}
}
