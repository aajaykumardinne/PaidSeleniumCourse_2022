package WindowPopUpHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowspopup_1 {

	public static void main(String[] args) {

		// Use case - 1 
		// at a time iterator deals with three or multiple windowids in this scenario
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// parent window
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		// child-window 1
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();

		// child-window 2
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();

		// getWindowhandles method get the windowId of the parent window and the child
		// windows

		Set<String> handles = driver.getWindowHandles();
		// Set is an Interface ,which does not store elements in the order, hence
		// the iterator is used
		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();

		System.out.println("parent windowid   is: " + parentWindowId);

		String childWindowId1 = it.next();
		System.out.println("child  windowid 1 is: " + childWindowId1);

		String childWindowId2 = it.next();
		System.out.println("child  windowid 2 is: " + childWindowId2);

		// driver is active when it is present on the specfic window of the browser
		driver.switchTo().window(childWindowId2);

		System.out.println("child window 2 title is: " + driver.getTitle());
		System.out.println("child window 2 url is: " + driver.getCurrentUrl());

		driver.close();

		// driver is active when it is present on the specfic window of the browser
		driver.switchTo().window(childWindowId1);

		System.out.println("child window 1 title is: " + driver.getTitle());
		System.out.println("child window 1 url is: " + driver.getCurrentUrl());

		driver.close();

		// driver is active when it is present on the specfic window of the browser
		driver.switchTo().window(parentWindowId);

		System.out.println("parent window title is: " + driver.getTitle());
		System.out.println("parent window url is: " + driver.getCurrentUrl());
		
		driver.quit();

	}
}
