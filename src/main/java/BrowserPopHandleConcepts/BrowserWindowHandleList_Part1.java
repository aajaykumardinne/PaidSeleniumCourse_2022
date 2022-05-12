package BrowserPopHandleConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList_Part1 {

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

		// top-casting
		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowId = handlesList.get(0);
		String childWindowId1 = handlesList.get(1);
		String childWindowId2 = handlesList.get(2);
		String childWindowId3 = handlesList.get(3);
		String childWindowId4 = handlesList.get(4);

		// switching to the child windows
		driver.switchTo().window(childWindowId1);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(childWindowId2);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(childWindowId3);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(childWindowId4);
		System.out.println(driver.getTitle());
		driver.close();
		
		// switching to the parent window
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
