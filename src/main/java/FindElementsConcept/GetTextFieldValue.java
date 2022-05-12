package FindElementsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextFieldValue {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		// how to capture the text present in the text fields
		// works only when there is a value attribute for the particular Web Element
		
		// get text is only for the links
		
		driver.findElement(By.id("login1")).sendKeys("aajaykumardinne70@gmail.com");
		
		String value = driver.findElement(By.id("login1")).getAttribute("value");
		System.out.println(value);
		
		
	}

}
