package FindElementsConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPageLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		// total numbers of links on the web page
		System.out.println("total number of links: " + linksList.size());

		// print all the value of links
		for (int i = 0; i<linksList.size(); i++) {
			String text = linksList.get(i).getText();
			if (!text.isEmpty()) { // blank text
				System.out.println(text);
			}

		}

	}

}
