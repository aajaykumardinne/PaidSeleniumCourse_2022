package GenericMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtil {
	
	static WebDriver driver;
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		// Selenium 4.x version
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does notnecessarily mean that the element is visible
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return the WebElement when it is present.
	 */
	public static WebElement waitForElementPresent(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return 
	 */
	public static WebElement waitForElementToBeVisible(By locator, int timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	/**
	 * This method assigns the Explicit wait time for the Javascript Alerts
	 * @param timeout
	 * @return the Alert if it is located.
	 */
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method is used to click on the OK or Continue button when Javascript Alert pop ups
	 * @param timeout
	 */
	public static void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}
	
	/**
	 * This method is used to click on the Cancel Button for the Javascript Alerts
	 * @param timeout
	 */
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	/**
	 * This method is used to get the text of the Alert generated
	 * @param timeout
	 * @return the Alert of type String
	 */
	public static String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}
	
	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * @return true when the URL contains the text
	 * 
	 */
	public static Boolean waitForUrl(int timeout, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	/**
	 *  expectation for the URL of the current page to be a specific url.
	 *  @return true when the URL is what it should be
	 */
	public static Boolean waitForUrlToBe(int timeout, String urlVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlToBe(urlVal));
	}
	
	/**
	 * Expectation for the URL to match a specific regular expression
	 * @param timeout
	 * @param urlMatch
	 * @return Expectation for the URL to match a specific regular expression
	 */
	public static Boolean waitForUrlMatches(int timeout, String urlMatch) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlMatches(urlMatch));
	}
	
	
	
	
	
	
	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitforElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * An expectation for checking that an element, known to be present on the DOM
	 * of a page, is visible. Visibility means that the element is not only
	 * displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitforElementVisibility(By locator, int timeOut) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param timeOut
	 * @return
	 */
	public static String waitForTitle(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * 
	 * @param url
	 * @param timeOut
	 * @return
	 */

	public static String waitForElementUrl(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
	}

	/**
	 * An expectation for the Javascript alert to be present on the Web Page.
	 * 
	 * @param timeOut
	 * @return
	 */
	public static boolean waitAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
		return true;

	}

	public static void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();

	}
	
	/**
	 * An expectation for checking that all elements present on the web page 
	 * that match the locatorare visible. 
	 * Visibility means that the elements are not only displayed 
	 * but also have a heightand width that is greater than 0.
	 * @param elements
	 * @param timeOut
	 * @return
	 */
	
	public static List<WebElement> visibilityOfAllElements(List<WebElement> elements, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		return elements;
		
	}
	
	/**
	 * An expectation for checking whether the given frame is available to switch to. 
	 * If the frameis available it switches the given driver to the specified frame.
	 * @param locator
	 * @param timeOut
	 */
	
	public static void waitForFrameTobePresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
}
