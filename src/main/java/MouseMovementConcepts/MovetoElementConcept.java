package MouseMovementConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElementConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		MovetoElementConcept obj = new MovetoElementConcept();

		String mp3player_locator = "MP3 Players";
		String text_Locator = "test 20 (0)";

		// can access the non-static methods with the object ref name
		obj.moveToElement(driver, mp3player_locator, text_Locator);

	}

	/**
	 * This method is used to move to the particular elements present on the web
	 * page
	 * 
	 * @param driver
	 * @param locator
	 * @throws InterruptedException
	 */
	public void moveToElement(WebDriver driver, String locator, String locator1) throws InterruptedException {

		Actions action = new Actions(driver);

		WebElement mp3PlayersLink = driver.findElement(By.linkText(locator));

		// build -- collect all the actions and perform it using perform method
		action.moveToElement(mp3PlayersLink).build().perform();
		
		Thread.sleep(5000);

		driver.findElement(By.linkText(locator1)).click();

	}
}
