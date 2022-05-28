package DropDownHandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenDropDownValues {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		// Using the EventListener

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		
		By searchField = By.xpath("//input[@placeholder='Search for products, brands and more']");
		
		getHiddenDropDownValues(searchField, "macbook pro");
		

	}

	public static void getHiddenDropDownValues(By locator, String value) throws InterruptedException {

		driver.findElement(locator)
				.sendKeys(value);
		Thread.sleep(5000); // pauses the appln to load the web elements for 5 secs.

		List<WebElement> hiddendropDownValList = driver.findElements(By.xpath("//div[starts-with(@class ,'lrtEPN')]"));

		for (WebElement e : hiddendropDownValList) {
			System.out.println(e.getText());
		}

	}

}
