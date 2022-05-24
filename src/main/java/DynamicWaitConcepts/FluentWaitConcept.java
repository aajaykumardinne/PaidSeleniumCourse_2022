package DynamicWaitConcepts;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	public static void main(String[] args) {

		// Explicit Wait
		// 1. WebDriverWait
		// 2. FluentWait
		// a. TimeOut b. pollingPeriod c.ignoringException

		// when to use
		// for handling the Ajax components

		WebDriver driver = WebDriverManager.chromedriver().create();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		final By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit']");

		waitForElementwithFluentWait(driver, emailId).sendKeys("dinnekumar@outlook.com");
		driver.findElement(password).sendKeys("Happymind_90");
		driver.findElement(loginBtn).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.pollingEvery(Duration.ofSeconds(3))
//			.ignoring(NoSuchElementException.class);
		

	}

	
	
	public static WebElement waitForElementFluentWait(WebDriver driver, By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	
	
	// Important for the interview
	public static WebElement waitForElementwithFluentWait(WebDriver driver,final By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;

	}

}
