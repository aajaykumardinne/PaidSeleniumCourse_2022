package BrowserPopHandleConcepts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList_Part2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// parent-window
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		// child-windows
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();

//		driver.findElement(By.xpath("")).click();

		Set<String> handles = driver.getWindowHandles();

		// top-casting
		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowId = handlesList.get(0);
		String childWindowId1 = handlesList.get(1);

		// switching to the child window 1
		driver.switchTo().window(childWindowId1);
		System.out.println(driver.getTitle());
		driver.close(); // window will be closed and the sessionId will be expired

		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());

		// switching to the child window -2
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		Set<String> handles1 = driver.getWindowHandles();

		// top-casting
		List<String> handlesList1 = new ArrayList<String>(handles1);

		String parentWindowId1 = handlesList1.get(0);
		String childWindowId2 = handlesList1.get(1);

		driver.switchTo().window(childWindowId2);
		System.out.println(driver.getTitle());
		driver.close(); // window will be closed and the sessionId will be expired

		driver.switchTo().window(parentWindowId1);
		System.out.println(driver.getTitle());

		// // switching to the child window -3
		By twitterId = By.xpath("//img[@alt='OrangeHRM on twitter']");
		driver.findElement(twitterId).click();
		Set<String> handles2 = driver.getWindowHandles();

		// top-casting
		List<String> handlesList2 = new ArrayList<String>(handles2);

		String parentWindowId2 = handlesList2.get(0);
		String childWindowId3 = handlesList2.get(1);

		driver.switchTo().window(childWindowId3);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains("OrangeHRM (@orangehrm) / Twitter"));
		System.out.println(driver.getTitle());
		driver.close(); // window will be closed and the sessionId will be expired

		driver.switchTo().window(parentWindowId2);
		System.out.println(driver.getTitle());
		
		// switching to the child window 4
		By youTubeId = By.xpath("//img[@alt='OrangeHRM on youtube']");
		driver.findElement(youTubeId).click();
		Set<String> handles3 = driver.getWindowHandles();

		// top-casting
		List<String> handlesList3 = new ArrayList<String>(handles3);

		String parentWindowId3 = handlesList3.get(0);
		String childWindowId4 = handlesList3.get(1);

		driver.switchTo().window(childWindowId4);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.titleContains("OrangeHRM (@orangehrm) / Twitter"));
		System.out.println(driver.getTitle());
		driver.close(); // window will be closed and the sessionId will be expired

		driver.switchTo().window(parentWindowId3);
		System.out.println(driver.getTitle());
		
		
	}

}
