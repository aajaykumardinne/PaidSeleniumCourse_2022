package WindowPopUpHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowdPopup {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// parent window
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		// pauses the web page for particular time untill all the elements are loading
		// completely waits for the 8000 millisec even thought the elements are loaded
		Thread.sleep(8000);
		
		// child window - facebook page
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		

		// getWindowhandles method get the windowId of the parent window and the child
		// window
		// Set is an Interface ,which does not store elements in the order, hence
		// the iterator is used
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindowdId = it.next();
		System.out.println("parent windowid is: " + parentWindowdId);

		String childWindowId = it.next();
		System.out.println("child windowd id is: " + childWindowId);

		driver.switchTo().window(childWindowId);

		System.out.println("child window title is: " + driver.getTitle());
		System.out.println("child window url is: " + driver.getCurrentUrl());

		driver.close();   // closes the specific browser windowd

		// driver is active when it is present on the specfic window of the browser
		driver.switchTo().window(parentWindowdId);

		System.out.println("parent window title is: " + driver.getTitle());
		System.out.println("parent window url is: " + driver.getCurrentUrl());

		driver.quit();  // closes all the browser windows

	}

}
