
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class DropDown {
 public static void main(String[] args) { 
	    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
	    WebDriver driver = new ChromeDriver();
	    driver.get(baseURL);

	    Select drpCountry = new Select(driver.findElement(By.name("country")));
	    drpCountry.selectByVisibleText("AUSTRALIA");

	

 }
}