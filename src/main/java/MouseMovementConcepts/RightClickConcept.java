package MouseMovementConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		Thread.sleep(3000);

		WebElement rightclickButton = driver.findElement(By.cssSelector(".context-menu-one"));

		Actions action = new Actions(driver);
		action.contextClick(rightclickButton).build().perform();
		
		String text = driver.findElement(By.xpath("//ul/li[contains(@class,'context-menu-icon-copy')]/span")).getText();
		System.out.println(text);

	}

}
