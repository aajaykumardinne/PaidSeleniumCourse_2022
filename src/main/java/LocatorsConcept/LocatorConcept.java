package LocatorsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		// page loading and element visibility both are different
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://app.hubspot.com/login");
		
		Thread.sleep(5000);
		
		// every element present on the web page is called the WebElement
		// Locators
		
		// 1. id - I - unique
//		WebElement email = driver.findElement(By.id("username"));
//		email.sendKeys("dinnekumar@outlook.com");
//		
//		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("Happysoul@15");
		
//		driver.findElement(By.id("username")).sendKeys("dinnekumar@outlook.com");
//		driver.findElement(By.id("password")).sendKeys("Happysoul@15");
//		driver.findElement(By.id("loginBtn")).click();
		
		// 2.name - II
//		driver.findElement(By.name("username")).sendKeys("dinnekumar@outlook.com");
		
		// 3.Xpath- III,dynamic ids
		// is a locator, not an attribute , address of element on the web page
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dinnekumar@outlook.com");
//		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Happysoul@15");
		
		// 4.cssSelector- III
		// is a locator, not an attribute
//		driver.findElement(By.cssSelector("#username")).sendKeys("dinnekumar@outlook.com");
//		driver.findElement(By.cssSelector("#password")).sendKeys("Happysoul@15");
		
		// 5.className - IV -- is not unique always
		driver.findElement(By.className("login-email")).sendKeys("dinnekumar@outlook.com");
		driver.findElement(By.className("login-password")).sendKeys("Happysoul@15");
		
		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3
		
		// 6.linkText -- only used for links
	//	driver.findElement(By.linkText("Sign up")).click();
		
		// 7.partial link Text 
		driver.findElement(By.partialLinkText("Sign")).click();
		
		// sign up
		// sign in
		// sign up with google and get some cool offers
		
		// 8.tagName
		
	}

}
