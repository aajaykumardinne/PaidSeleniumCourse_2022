package PaidTestNGCourse_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgAnnotations {

	// annotations are the prerequistes for the test cases.
	// it is not mandatory to write all the annotations.
	// it is not also compulsory to write @BeforeTest, @BeforeMethod
	// annotation

	/*
	 * BS BT BC
	 * 
	 * BM T1 AM
	 * 
	 * BM T2 AM
	 * 
	 * BM T3 AM
	 * 
	 * AC AT AS
	 * 
	 * 
	 */
	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By returnLogin = By.linkText("Return to login");

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite -- prepare the test data");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test --- DB Connection");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class--- get the value from DB");
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("before method -- set up");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(priority = 1)
	public void signUpLinkTest() {
		System.out.println("test method -- signup link");
		Assert.assertTrue(driver.findElement(signUp).isDisplayed());

	}

	@Test(priority = 2)
	public void loginTitleTest() {
		System.out.println("test method --- login title");
		String title = driver.getTitle();
		System.out.println("current page title is:" + title);
		Assert.assertEquals(title, "HubSpot Login");

	}

	@Test(priority = 3)
	public void signInTest() {
		System.out.println("test method --- signin title");
		driver.findElement(username).sendKeys("dinnekumar@outlook.com");
		driver.findElement(password).sendKeys("Happysoul@15");
		driver.findElement(login).click();
		Assert.assertTrue(driver.findElement(returnLogin).isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		System.out.println("after method --- tearDown");
		driver.quit();

	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class -- delete the value from the DB");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after Test --- disconnect the DB");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite-- delete test data");
	}

}
