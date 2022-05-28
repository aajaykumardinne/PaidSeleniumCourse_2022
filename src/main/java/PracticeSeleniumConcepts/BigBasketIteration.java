package PracticeSeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketIteration {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com/");

		WebElement shopByCategoryElement = driver
				.findElement(By.cssSelector("li.dropdown.full-wid.hvr-drop a.dropdown-toggle.meganav-shop"));

		Actions action = new Actions(driver);
		action.moveToElement(shopByCategoryElement).build().perform();

		List<WebElement> list1Element = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//a"));

		for (WebElement e1 : list1Element) {
			action.moveToElement(e1).perform();
			System.out.println(e1.getText());

			List<WebElement> list2Element = driver
					.findElements(By.xpath("(//ul[@class ='nav nav-pills nav-stacked']) [2] //a"));

			for (WebElement e2 : list2Element) {
				action.moveToElement(e2).perform();
				System.out.println(e2.getText());

				List<WebElement> list3Element = driver
						.findElements(By.xpath("(//ul[@class= 'list-unstyled']) [3] //a"));
				
				for(WebElement e3 : list3Element) {
					System.out.println(e3.getText());
					
				}
			}

		}

	}

}
