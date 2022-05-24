package GenericMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import JavascriptConcept.JavascriptUtil;

public class Util {

	static WebDriver driver;

	public Util(WebDriver driver) {
		Util.driver = driver;
	}

	/**
	 * This method is used to create the Webelement on the basis of By locator
	 * 
	 * @param locator
	 * @return
	 */

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			// JavascriptUtil.flash(element, driver);
		} catch (Exception e) {
			System.out.println("some exception occured while creating the webelement...");
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This method is used to click on a element
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking on the webelement...");
			System.out.println(e.getMessage());
		}

	}

	/**
	 * This method is used pass the values to the webelement
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occured while while passing the value to the webelement...");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method is used to perform the sendKeys method using the Action class
	 * @param locator
	 * @param value
	 */
	
	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator),value).perform();;
	}
	
	/**
	 * This method is used to perform the click Method using the Action class
	 * @param locator
	 */
	
	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}