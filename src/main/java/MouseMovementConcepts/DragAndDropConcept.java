package MouseMovementConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");

		// switching to the frame
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);

		Actions action = new Actions(driver);

		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));

//		action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();

		// applies only for the WebElements
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
		// switching to the default web page -- coming out of the frame
		driver.switchTo().defaultContent();

	}

}
