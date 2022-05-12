package CharSequenceConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CharSequence {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement email = driver.findElement(By.id("input-email"));
		
		// StringBuilder, StringBuffer , String , Keys
		StringBuilder username = new StringBuilder();
		username.append("Aajay")
				.append(" ")  // blank space
				.append("Kumar");
		
		String space = " ";
		
		StringBuffer userInfo = new StringBuffer();
		userInfo.append("Selenium")
				.append(" ") 
				.append("WebDriver")
				.append(" ");
		
		String author = "Aajay Kumar Dinne";
		
	email.sendKeys(username, space, userInfo, author,Keys.TAB);
	//email.sendKeys(null);
		
				
				
		

	}

}
