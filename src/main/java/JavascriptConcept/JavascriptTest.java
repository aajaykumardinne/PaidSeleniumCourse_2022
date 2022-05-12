package JavascriptConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//		driver.get("https://classic.freecrm.com/");

	//	Thread.sleep(3000);

		String title = JavascriptUtil.getTitleByJS(driver);
		System.out.println(title);

//	    JavascriptUtil.generateAlert(driver, "Web Automation");

//		JavascriptUtil.refreshBrowserByJS(driver);

//		System.out.println(JavascriptUtil.getBrowserInfo(driver));

		driver.navigate().to("https://app.hubspot.com/login");
		
		driver.get("https://classic.freecrm.com/");

		Thread.sleep(3000);
//		
//		JavascriptUtil.sendKeysUsingWithId(driver, "username", "dinnekumar@outlook.com");
//		JavascriptUtil.sendKeysUsingWithId(driver, "password", "Happysoul@15");
//		WebElement loginButton = driver.findElement(By.id("loginBtn"));
//		JavascriptUtil.clickElementByJS(driver, loginButton);
		
//		WebElement loginFormElement = driver.findElement(By.id("hs-login"));
//		JavascriptUtil.drawBorder(driver, loginFormElement);
		
//		WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
//		JavascriptUtil.flash(loginFormElement, driver);
		
		// System.out.println(JavascriptUtil.getPageInnerText(driver));

//		JavascriptUtil.scrollPageDown(driver);
		
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password?"));
		JavascriptUtil.scrollIntoView(driver, forgotPassword);
		
		
		
	}

}
