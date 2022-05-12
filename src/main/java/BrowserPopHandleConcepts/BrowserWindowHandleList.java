package BrowserPopHandleConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// parent window
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		// child window
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();

		// this method gets the windowid of all open windows i.e parent and child window
		Set<String> handles = driver.getWindowHandles();

		// top-casting
		List<String> handlesList = new ArrayList<String>(handles);

//		for(String e : handlesList) {
//			System.out.println(e); // prints the windowid of both the windows
//		}

		String parentWindowdId = handlesList.get(0);
		String childWindowId = handlesList.get(1);

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindowdId);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
