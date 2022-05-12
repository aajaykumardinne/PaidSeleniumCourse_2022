package PracticeSeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverLearning {

	public static void main(String[] args) {

		// WebDriver is the Interface and hence object can not created
		// ChromeDriver is the child class of parent Interface WebDriver

		// child class object can be referred by parent interface ref variable
		// top-casting is allowed

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // 1. open the browser

		driver.get("https://demo.opencart.com/index.php?route=account/login"); // 2. launch the url

		// Text is available in the form in String for the web application
		String title = driver.getTitle(); // 3. get the current page title
		System.out.println(title);

		// 4. always write the validation points in testing the web application
		if (title.equals("Account Login")) {
			System.out.println("Correct title");
		} else {
			System.out.println("In-correct title");
		}

		System.out.println(driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());

		// driver.quit();            // close the browser 

		driver.close();       // close the browser
		System.out.println(driver.getTitle());
	}

}
