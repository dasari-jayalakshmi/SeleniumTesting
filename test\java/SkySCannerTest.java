import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pageObjects.SearchPage;

public class SkySCannerTest {

	public static void main(String[] args) throws InterruptedException{
		String baseURL = "https://www.expedia.com.au/Flights";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		SearchPage search = new SearchPage(driver);
		String homePageHeaderText = search.getHeaderMessage();
		Boolean match = homePageHeaderText.equalsIgnoreCase("Search flights");
		Assert.assertTrue(match);
		search.selectFromLocation("Sydney");
	}
}
