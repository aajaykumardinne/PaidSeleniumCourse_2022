package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		// page objects
		By emailId = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginBtn");
		

		Util util = new Util(driver);

		util.waitForElementPresent(emailId, 10);
		util.doSendKeys(emailId, "dinnekumar@outlook.com");
		util.doSendKeys(password, "Happysoul@15");
		util.doClick(loginButton);

	}
	

}
