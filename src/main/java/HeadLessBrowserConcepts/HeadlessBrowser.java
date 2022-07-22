package HeadLessBrowserConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {

	public static void main(String[] args) {
		
		// headless : no UI
		// testing is happening behind the scene
		// faster than noraml UI mode
		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions chromeopt = new ChromeOptions();
//		chromeopt.addArguments("--headless");
//		
//		WebDriver driver = new ChromeDriver(chromeopt);
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
	//	options.addArguments("--headless");
		options.setHeadless(true);
		
		WebDriver driver = new FirefoxDriver(options);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

}
