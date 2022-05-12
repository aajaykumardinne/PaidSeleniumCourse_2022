package NewWindowConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabhandle {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		String parentWindowId = driver.getWindowHandle();
		
		
		driver.switchTo().newWindow(WindowType.TAB); // Selenium 4.x
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		driver.close();  // close child window
		
		// switch to the parent window
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		
		
	}
	
	

}
