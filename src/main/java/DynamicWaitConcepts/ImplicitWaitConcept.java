package DynamicWaitConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {

	public static void main(String[] args) {

		// synchronization:
		// there should be a sync between the selenium code and the web page.

		// dynamic wait
		// implicitly wait
		// global wait : it will be applicable for all the web elements
		// FE : imp wait will be applied by default
		// it works only for web elements
		// it does not work for non web elements: alerts, url, title
		// we avoid imp wait in framework design

		/**
		 * Specifies the amount of time the driver should wait when searching for an
		 * element if it is not immediately present. When searching for a single
		 * element, the driver should poll the page until the element has been found, or
		 * this timeout expires before throwing a NoSuchElementException.
		 * 
		 * When searching for multiple elements, the driver should poll the page until
		 * at least one element has been found or this timeout has expired.
		 * 
		 * Increasing the implicit wait timeout should be used judiciously as it will
		 * have an adverse effect on test run time, especially when used with slower
		 * location strategies like XPath.
		 * 
		 */

		
		// timeout = 15secs ->> 5 secs -> 10 secs ignored
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement emailId = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));

		Actions action = new Actions(driver);
		action.sendKeys(emailId, "dinnekumar@outlook.com").build().perform();
		action.sendKeys(password, "happy").build().perform();

	}

}
