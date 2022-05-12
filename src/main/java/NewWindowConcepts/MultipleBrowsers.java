package NewWindowConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		String parentWindowId = driver.getWindowHandle();
		

		// switching the domain:
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver1 = new ChromeDriver();
//		driver1.get("https://www.amazon.in/");
//		driver1.close();
		
		// switch to the  same domain.
		driver.navigate().to("https://www.amazon.in/");
		
		//switch to a  different domain.
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
