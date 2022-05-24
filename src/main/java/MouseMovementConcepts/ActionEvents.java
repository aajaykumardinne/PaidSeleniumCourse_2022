package MouseMovementConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericMethods.Util;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionEvents {

	public static void main(String[] args) {

		// sendKeys and click method can be used in Actions class
		// click using method using Actions class is equal to moveToElement().click();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

//		WebElement email = driver.findElement(By.id("username"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement loginButton=driver.findElement(By.id("loginBtn"));
//		
//		Actions action = new Actions(driver);
//		action.sendKeys(email, "dinnekumar@outlook.com").build().perform();
//		action.sendKeys(password,"Happysoul@15").build().perform();
//		action.click(loginButton).build().perform();

		Util util = new Util(driver);
		util.doActionSendKeys(By.id("input-email"), "dinnekumar@outlook.com");
		util.doActionSendKeys(By.id("input-password"), "Happymind_90");
		util.doActionClick(By.cssSelector("input.btn.btn-primary"));

	}

}
