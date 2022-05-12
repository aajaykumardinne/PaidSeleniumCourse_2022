package PracticeSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementExample {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		Thread.sleep(7000);

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(3000);

		String performanceElement_locator = "//a[@id='menu__Performance']/b";

		String manageReviewsElement_locator = "menu_performance_ManageReviews";

		String reviewList_Locator = "Review List";

		moveToElementSteps(driver, performanceElement_locator, manageReviewsElement_locator, reviewList_Locator);

	}

	/**
	 * This method is used to move to particular element on the web page which includes using two times moveToElement method 
	 * @param driver
	 * @param locator1
	 * @param locator2
	 * @param locator3
	 */
	public static void moveToElementSteps(WebDriver driver, String locator1, String locator2, String locator3) {

		WebElement performanceElement = driver.findElement(By.xpath(locator1));

		Actions action = new Actions(driver);
		action.moveToElement(performanceElement).build().perform();

		WebElement manageReviewsElement = driver.findElement(By.id(locator2));

		Actions action1 = new Actions(driver);
		action1.moveToElement(manageReviewsElement).build().perform();

		WebElement reviewList = driver.findElement(By.linkText(locator3));
		reviewList.click();

	}
}
