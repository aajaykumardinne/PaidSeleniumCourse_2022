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

public class SignUpTest {
	
	WebDriver driver;
	
	By signUp = By.linkText("Sign up");
	By freeAccount = By.xpath("//h1//i18n-string[text()='Create your free account']");
	By privacyPolicyLink = By.linkText("Privacy Policy");
	
	
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
	public void verifyCreateFreeAccountTest() {
	//	driver.findElement(signUp).click();
		Assert.assertTrue(driver.findElement(freeAccount).isDisplayed());
	}
	
	
	@Test(priority = 2)
	public void privacyPolicyLinkTest() {
		Assert.assertTrue(driver.findElement(privacyPolicyLink).isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
