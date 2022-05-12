package iFrame_ShadowDOMConcepts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://selectorshub.com/xpath-practice-page/");

		driver.switchTo().frame("pact");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement teaElement = (WebElement) js
				.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");

		String jse = "arguments[0].setAttribute('value', 'Green Masala Tea')";
		js.executeScript(jse, teaElement);

		WebElement lunchElement = (WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
		String jse1 = "arguments[0].setAttribute('value', 'Pula with Brinjal Curry')";
		js.executeScript(jse1, lunchElement);

	}

}
