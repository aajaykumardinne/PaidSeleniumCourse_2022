package PracticeSeleniumConcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickAssignment {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		String rightClickMeButton_locator = "context-menu-one";

		String rightClickList_locator = "//ul[@class='context-menu-list context-menu-root']/li";

		ArrayList<String> list = getRightClickElements(driver, rightClickMeButton_locator, rightClickList_locator);
		System.out.println(list);

	}

	/**
	 * This method is used to get the right click elements present on the web page
	 * 
	 * @param driver
	 * @param locator1
	 * @param locator2
	 * @return A self reference
	 */

	public static ArrayList<String> getRightClickElements(WebDriver driver, String locator1, String locator2) {

		WebElement rightClickMeButton = driver.findElement(By.className(locator1));

		Actions action = new Actions(driver);
		action.contextClick(rightClickMeButton).build().perform();

		List<WebElement> rightClickList = driver.findElements(By.xpath(locator2));
		System.out.println("Total number of elements in the list: " + rightClickList.size());

		ArrayList<String> ar = new ArrayList<String>();

		for (int i = 0; i < rightClickList.size(); i++) {
			String elements = rightClickList.get(i).getText();
			// System.out.println(elements);
			if (!elements.isBlank()) {
				ar.add(elements);
			}
		}
		

		return ar;

	}

}