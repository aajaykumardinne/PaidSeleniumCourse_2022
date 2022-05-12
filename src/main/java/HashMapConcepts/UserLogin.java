package HashMapConcepts;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {

	public static void main(String[] args) {

		// Hashmap with selenium

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		doLogin(driver, getUserMap(), "doctor");

	}

	public static Map<String, String> getUserMap() {
		Map<String, String> userMap1 = new HashMap<String, String>();
		userMap1.put("admin", "admin_admin123");
		userMap1.put("doctor", "doctor20@gmail.com_doctor34");
		userMap1.put("patient", "tarun@gmail.com_tarunkumar56");

		return userMap1;
	}

	public static void doLogin(WebDriver driver, Map<String, String> userMap1, String userkey) {
		driver.findElement(By.id("username")).sendKeys(userMap1.get(userkey).split("_")[0]);
		driver.findElement(By.id("password")).sendKeys(userMap1.get(userkey).split("_")[1]);

	}
}
