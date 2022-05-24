package StreamWithListConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinksWithStreams {

	public static void main(String[] args) {
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.freshworks.com/");

		driver.findElements(By.cssSelector("ul.footer-nav li a"))
				.stream()
					.filter(ele -> !ele.getText().isBlank())
					.forEach(ele -> System.out.println(ele.getText()));
				
					
		
	}

}
