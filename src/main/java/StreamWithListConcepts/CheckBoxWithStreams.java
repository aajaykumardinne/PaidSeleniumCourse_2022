package StreamWithListConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxWithStreams {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElements(By.cssSelector("td.select-checkbox"))
				.stream()
				.forEach(ele -> ele.click());
		
		Thread.sleep(7000);
				
		
	}

}
