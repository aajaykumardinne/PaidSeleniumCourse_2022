package com.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By returnLogin = By.linkText("Return to login");
	
	
	@BeforeTest
	@Parameters({"url", "browser"})
	public void setUp(String appUrl , String browserName) throws Exception {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("please pass the right browser");
			throw new Exception("NoSuchBrowserException");
		}

		
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(priority = 1)
	public void signUpLinkTest() {
		
		Assert.assertTrue(driver.findElement(signUp).isDisplayed());

	}

	@Test(priority = 2)
	public void loginTitleTest() {
		String title = driver.getTitle();
		System.out.println("current page title is:" + title);
		Assert.assertEquals(title, "HubSpot Login");

	}

	@Test(priority = 3)
	@Parameters({"username", "password"})
	public void signInTest(String emailId, String pwd) {
		driver.findElement(username).sendKeys(emailId);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		Assert.assertTrue(driver.findElement(returnLogin).isDisplayed());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
	

}
