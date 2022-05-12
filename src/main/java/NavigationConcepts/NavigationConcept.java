package NavigationConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		// waits for the page to completely  load and then perform the next actions
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		// does not  waits for the page for complete loading , it performs the actions without complete loading the page
		driver.navigate().to("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());

	}

}
