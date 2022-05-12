package BrowserWindowIteratorConcept;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowIterator {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// parent window
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		// child-windows
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();

		while (it.hasNext()) {
			
			String childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("OrangeHRM")) {
				driver.switchTo().window(parentWindowId);
				
				}
			driver.close();
		}

//		driver.switchTo().window(parentWindowId);

		
	}

}
