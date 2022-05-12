package PracticeSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");

		// 1. id
//		driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Aajay Kumar");
//		driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("Dinne");

		// 2. name
//		driver.findElement(By.name("FirstName")).sendKeys("Aajay Kumar");
//		driver.findElement(By.name("LastName")).sendKeys("Dinne");
		
		
		// 3.Xpath 
//		driver.findElement(By.xpath("//*[@id='Form_submitForm_FirstName']")).sendKeys("Aajay Kumar");
//		driver.findElement(By.xpath("//*[@id='Form_submitForm_LastName']")).sendKeys("Dinne");
		
		// 4.cssSelector
//		driver.findElement(By.cssSelector("#Form_submitForm_FirstName")).sendKeys("Aajay Kumar");
//		driver.findElement(By.cssSelector("#Form_submitForm_LastName")).sendKeys("Dinne");
		
		// 5.className
		// we need to select the className selector in such a way it is unique but it is not unique always
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.className("_9npi")).sendKeys("Dinne");
		
		// inputtext _55r1 _6luy  
		// inputtext _55r1 _6luy _9npi
		
		
		// 6. linkText
//		driver.navigate().to("https://classic.freecrm.com/index.html");
//		driver.findElement(By.linkText("Sign Up")).click();
		
		// 7. partialLinkText
//		driver.navigate().to("https://classic.freecrm.com/index.html");
//		driver.findElement(By.partialLinkText("Sign ")).click();
		
		// 8.tagName
		
		
	}

}
