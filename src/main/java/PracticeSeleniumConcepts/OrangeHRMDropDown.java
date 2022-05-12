package PracticeSeleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMDropDown {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/hris-hr-software-demo/#demoRequest");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		By country = By.id("Form_submitForm_Country");
		
	//	doSelectByValue(country, "Canada");
	//	doSelectByIndex(country, 6);

	//	doSelectDropDownValue(country, "index", "5");
		
	   doSelectDropDownValue(country, DropDown.INDEX.toString(), "8");
		
	

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownValue(By locator, String type, String value) {
		Select select = new Select(getElement(locator));
		
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "VisibleText":
			select.selectByVisibleText(value);
		case "Value" :
			select.selectByValue(value);
		default:
			System.out.println("please pass the right selection criteria");
			break;
		}
	}

	public static void doSelectByVisibleText(By locator, String value) {

		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);

	}

	public static void  doSelectByIndex(By locator, int index) {

		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public static void doSelectByValue(By locator, String value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
