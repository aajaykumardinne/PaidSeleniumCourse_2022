package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleWebApplication {

	public static void main(String[] args) {

		//WebDriverManager: No Need to write WebDriver driver = new ChromeDriver();
		// from version 5.1.1
		
		ChromeOptions chromeOpt = new ChromeOptions();
	//	chromeOpt.addArguments("--headless");
		chromeOpt.setHeadless(true);
		
		
//		WebDriver driver = WebDriverManager.chromedriver().create();
		
		WebDriver driver = WebDriverManager.chromedriver().capabilities(chromeOpt).create();
		
		driver.get("https://demo.opencart.com/index.php?route=account/account");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	//	driver.close();

		
	}

}
