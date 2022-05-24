package PaidTestNGCourse_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	// Selenium does not perform validations of the data present on the web page
	// hence we are using TestNg for writing the validations with the help
	// of the Assert class

	// Before annotations -- @BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod
	// Test annotations --- @Test
	// After annotations -- @AfterMethod, @AfterClass, @AfterTest, @AfterSuite

	// if priority is not given for @Test annotations then test cases are executed
	// based on the
	// alphabetical order.

	// Diff between @BeforeTest and @BeforeMethod
	
	// @BeforeTest --- use when there are few test cases to execute for the web application.
	// opens the browser once at a time for all the test cases in @BeforeTest annotation.
	// less time for the execution
	
	// @BeforeMethod --- use when there are more number of test cases to execute for web application.
	// opens the browser every single time for each test case to execute for the @BeforeMethod annotation.
	// more time for the execution.
	// 95% follow this approach.

	WebDriver driver;

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By returnLogin = By.linkText("Return to login");

//	@BeforeTest
	@BeforeMethod
	public void setUp() {
		long startTime = System.currentTimeMillis();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);

	}

	@Test(priority = 1)
	public void signUpLinkTest() {
		long startTime = System.currentTimeMillis();
		// if entire driver.findElement(signup).isDisplayed() is true test case will
		// be passed
		// if entire driver.findElement(signup).isDisplayed() is false test case will
		// be failed.
		Assert.assertTrue(driver.findElement(signUp).isDisplayed());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}

	@Test(priority = 2)
	public void loginTitleTest() {
		long startTime = System.currentTimeMillis();
		
		String title = driver.getTitle();
		System.out.println("current page title is:" + title);
		// comparing the actual title --- which is generating after the selenium script
		// expeced title --- the title which is present on the web page
		Assert.assertEquals(title, "HubSpot Login");
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

	@Test(priority = 3)
	public void signInTest() {

		long startTime = System.currentTimeMillis();
		
		driver.findElement(username).sendKeys("dinnekumar@outlook.com");
		driver.findElement(password).sendKeys("Happysoul@15");
		driver.findElement(login).click();
		Assert.assertTrue(driver.findElement(returnLogin).isDisplayed());
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
                       
	}

//	@AfterTest
	@AfterMethod
	public void tearDown() {
		long startTime = System.currentTimeMillis();
		
		driver.quit();
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

}
