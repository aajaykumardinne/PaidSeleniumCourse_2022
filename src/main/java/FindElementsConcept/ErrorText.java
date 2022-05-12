package FindElementsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorText {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
		driver.findElement(By.id("username")).sendKeys("aajaykumardinne70@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("aajaykumardinne");
		
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(3000);
		
		// to get the text when wrong values are entered in the checkbox
		String errorText =driver.findElement(By.className("private-alert__title")).getText();
		System.out.println(errorText);
		
		
		

	}

}
