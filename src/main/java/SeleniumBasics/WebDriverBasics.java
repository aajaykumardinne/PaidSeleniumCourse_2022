package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		// ChromeDriver.exe acts as Server
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		// top-casting concept
		WebDriver driver = new ChromeDriver(); // 1. open the browser
//		
//		RemoteWebDriver driver1 = new ChromeDriver();
//		driver1.getTitle();
//		driver1.get("");
		
		// session id is created and communicates with the browser
		driver.get("https://amazon.in"); // 2. enter the url

		
		String title = driver.getTitle(); // 3. get the page title
		System.out.println(title);

		// 4. validation point -- important step to find the bugs in the web application
		if (title.equals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			System.out.println("correct title");
		}
		

		else {
			System.out.println("in-correct title");
		}

		System.out.println(driver.getCurrentUrl());

		// System.out.println(driver.getPageSource());

		driver.quit(); // close the browser
		
		//driver.close(); // close the browser
		System.out.println(driver.getTitle()); // Session ID is null. Using WebDriver after calling quit()?
	}

}
