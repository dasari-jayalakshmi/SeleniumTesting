
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;

public class DropDown {
 public static void main(String[] args) throws InterruptedException { 
	    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
	    WebDriver driver = new ChromeDriver();
	    driver.get(baseURL);
	    
	    
	    //1. Fill FirstName
	    driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("Jayalakshmi");
	    
	    //2. LastName
	    driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(3) td:nth-child(2) > input:nth-child(1)")).sendKeys("Dasari");

	    //3. Phone
	    driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys("0444444444");
	    
	    //4. Email
	    driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("dasari.jayalakshmi17@gmail.com");
	    
	    //5. Address
	    driver.findElement(By.xpath("//tbody/tr[7]/td[2]/input[1]")).sendKeys("1111 Maple Tree road");
	    
	    //6. City
	    driver.findElement(By.xpath("//tbody/tr[8]/td[2]/input[1]")).sendKeys("WestMead");
	    
	    
	    //7. State
	    driver.findElement(By.xpath("//tbody/tr[9]/td[2]/input[1]")).sendKeys("NSW");
	    
	    //8. Postal Code
	    driver.findElement(By.xpath("//tbody/tr[10]/td[2]/input[1]")).sendKeys("2145");
	    
	    //9. Country selection
	    Select drpCountry = new Select(driver.findElement(By.name("country")));
	    drpCountry.selectByVisibleText("AUSTRALIA");
	    
	   //10. User name
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("User12345");

	   //11. Password
	    driver.findElement(By.xpath("//tbody/tr[14]/td[2]/input[1]")).sendKeys("12345");

	    
	   //12. Confirm Password 
	    driver.findElement(By.xpath("//tbody/tr[15]/td[2]/input[1]")).sendKeys("12345");
	    
	   //13. Click submit button
	    driver.findElement(By.xpath("//tbody/tr[17]/td[1]/input[1]")).click();
	    
	    //14. wait until you get success message 
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[3]/td[1]")));

	

 }
}