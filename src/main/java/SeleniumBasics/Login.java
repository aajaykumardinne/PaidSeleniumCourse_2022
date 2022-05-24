package SeleniumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String userId = js.executeScript("return document.querySelector(\"*[type='email']\").getAttribute(\"id\")").toString();
		
		driver.findElement(By.id(userId)).sendKeys("dinnekumar@outlook.com");

	}

}
