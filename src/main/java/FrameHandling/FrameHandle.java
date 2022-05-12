package FrameHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {

		// According to the W3C standards frames should not be included in the web page

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames");

		WebElement frameElement = driver.findElement(By.name("content"));

		driver.switchTo().frame(frameElement);

//		driver.switchTo().frame(4);
//		
//		driver.switchTo().frame("content");

		// number of frames present in the web application
//		List<WebElement> frameList = driver.findElements(By.tagName("frame"));
//		System.out.println("Total no of frames: "  + frameList.size());

		String text = driver.findElement(By.cssSelector("body > h1")).getText();
		System.out.println(text);

		// coming out of the frame webelement and back to the web page
		driver.switchTo().defaultContent();

		// switching to the parent frame
		driver.switchTo().parentFrame();
	}

}
