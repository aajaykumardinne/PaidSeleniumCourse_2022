package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleWebApp {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		//top-casting - child clas object can be referred by parent interface ref name
		WebDriver driver = new ChromeDriver();
		
		// driver is the ref variable/name 
		// driver launches the browser
		
//		driver = new ChromeDriver();  // launches the browser
//		
//		driver = new ChromeDriver();
//		
		
		driver.get("https://classic.freecrm.com/index.html");
		
		
List<WebElement>	list = driver.findElements(By.xpath("//button[@class ='signup']"));
		
		System.out.println(list.size());

	}

}
