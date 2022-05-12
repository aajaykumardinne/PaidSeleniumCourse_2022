package NavigationConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetandNavigate {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		// waits for the page to completely  load and then perform the next actions
		// used to launch the url
		// used in testing the web applications in real time.
		driver.get("https://www.amazon.in/");
		
		// does not  waits for the page for complete loading , it performs the actions without complete loading the page.
		// used to launch the url
		System.out.println(driver.getTitle());
		
}


}
