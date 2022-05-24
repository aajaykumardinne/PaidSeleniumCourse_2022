package GenericMethods;

import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitUtil {

	// FluentWait is used for handling the Ajax components.
	// It is applied for the particular WebElement

	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible.
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOut
	 * @param pollingTime
	 * @return the WebElement once it is located 
	 */

	public static WebElement waitForElementPresentWithFluentWait(WebDriver driver, By locator, int timeout, int pollingTime) {

		// top-casting
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return the WebElement once it is located and visible
	 */
	
	public static WebElement waitForElementVisibleWithFluentWait(WebDriver driver, By locator, int timeout, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	/**
	 * An expectation for checking whether the given frame is available to switch to. 
	 * If the frameis available it switches the given driver to the specified frame.
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return the WebDriver instance after frame has been switched
	 */
	public static WebDriver waitForFrameWithFluentWait(WebDriver driver, By locator, int timeout, int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(timeout))
								.pollingEvery(Duration.ofSeconds(pollingTime))
								.ignoring(NoSuchFrameException.class);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	/**
	 * This method is used to assign the Fluent Wait for the Alerts.
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return the Alert if the alert is present in the web page
	 */
	public static Alert waitForAlertWithFluentWait(WebDriver driver,int timeout, int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(timeout))
									.pollingEvery(Duration.ofSeconds(pollingTime))
									.ignoring(NoAlertPresentException.class);
		
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	/**
	 * Expectation for the URL to match a specific regular expression
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @param url
	 * @return true if the URL matches the specified regular expression
	 */
	public static Boolean waitForUrlWithFluentWait(WebDriver driver,int timeout, int pollingTime, String url) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(timeout))
								.pollingEvery(Duration.ofSeconds(pollingTime))
								.ignoring(MalformedURLException.class);
								
		return wait.until(ExpectedConditions.urlMatches(url));
								
		
	}
	
		
	/**
	 * An expectation for checking the title of a page.
	 * @param driver
	 * @param timeout
	 * @param pollingTime
	 * @param title
	 * @return true when the title matches, false otherwise
	 *
	 */
  public static Boolean waitForTitleWithFluentWait(WebDriver driver, int timeout, int pollingTime , String title) {
	  
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			                 .withTimeout(Duration.ofSeconds(timeout))
			                 .pollingEvery(Duration.ofSeconds(pollingTime));
			                 
	  return wait.until(ExpectedConditions.titleIs(title));	                 
	  
	  
  }
	
  
	
}
