package PaidTestNGCourse_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	// Assert means Hard Assert
	// diff between assert and verify
	// Soft Assert and Hard assert
	
	WebDriver driver;
	SoftAssert softAssert;

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By returnLogin = By.linkText("Return to login");

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com/login");
		softAssert = new SoftAssert();

	}

	// never use if-else when validating the test cases.
	// always use Assert class
	@Test(priority = 1)
	public void loginPageTitleTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("HubSpot"));

		String title = driver.getTitle();
		System.out.println("page title is: " + title);
//		if(title.equals("HubSpot Login123")) {
//			System.out.println("PASS");
//		}
//		else {
//			System.out.println("FAIL");
//		}
		Assert.assertEquals(title, "HubSpot Login" , "login page title is mismatched");
	}

	@Test(priority = 2)
	public void signUpLinkTest() {
		Assert.assertTrue(driver.findElement(signUp).isDisplayed(), "sign up link is not found");
	}

	@Test(priority = 3)
	public void signInTest() {
		driver.findElement(username).sendKeys("dinnekumar@outlook.com");
		driver.findElement(password).sendKeys("Happysoul@15");
		driver.findElement(login).click();
		
		softAssert.assertTrue(driver.findElement(returnLogin).isDisplayed(), "return to login link is not found");
		
		String header = driver.findElement(By.xpath("//h1/span")).getText();
		softAssert.assertEquals(header, "Enter the code we emailed to 23", "header text is not matched");
		
		String title = driver.getTitle();
		System.out.println("home page title is: " + title);
		softAssert.assertEquals(title, "HubSpot Login", "home page title is not matched");
		
		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
