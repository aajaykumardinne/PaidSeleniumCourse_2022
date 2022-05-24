package DynamicWaitConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// 1. ImplictlylWait: global wait
		// 2. Explicit Wait: for a specific element, custom wait, non web elements
		// (alerts, url, title)
		// a. WebDriverWait
		// b. FluentWait
		// WebDriverWait(C) extends FluentWait(C) implements Wait (Interface) - until();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@class='btn btn-primary']");
		By register = By.linkText("Register");

		clickWhenReady(register, 20);

//		System.out.println(waitForTitle("Account Login", 10));
//
//		// System.out.println(driver.getTitle());
//

//
//		waitForElementTobeVisible(emailId, 10).sendKeys("dinnekumar@outlook.com");
//		getElement(password).sendKeys("Happymind_90");
//		getElement(loginBtn).click();

	}

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
	public static WebElement waitForElementTobeVisible(By locator, int timeOut) {
		// Selenium 4.x version
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
