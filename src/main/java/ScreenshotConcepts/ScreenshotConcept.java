package ScreenshotConcepts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotConcept {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Alert is not a WebElement
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		Thread.sleep(5000);

		takePageScreenshot(driver, "Hubspot_loginpage");
		
		WebElement email = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton=driver.findElement(By.id("loginBtn"));
		
		email.sendKeys("dinnekumar@gmail.com");
		password.sendKeys("Hierry@34");
		loginButton.click();
		
		Thread.sleep(5000);
		
//		takeWebElementScreenshot(email, "emailId");
//		takeWebElementScreenshot(password, "password");
//		takeWebElementScreenshot(loginButton, "loginButton");
		
		takePageScreenshot(driver, "loginPageError");
		
		driver.quit();
		

	}
	
	public static void takePageScreenshot(WebDriver driver, String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/Screenshots/"+ fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void takeWebElementScreenshot(WebElement element, String fileName) {
		File srcFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/Screenshots/"+ fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
