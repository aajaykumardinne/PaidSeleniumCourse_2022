package CalenderHandleConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandle_Example {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//p/span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
		
		String departMonthVal = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']) [2]")).getText();

		while(!departMonthVal.equals("October 2022")) {
			driver.findElement(By.xpath("(//div[@class='DayPicker-NavBar']/span) [2]")).click();
			departMonthVal = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']) [2]")).getText();
		}
		
		
		List<WebElement> daysValList = driver.findElements(By.xpath("(//div[@class='DayPicker-Month']) [2]   //div[@class='DayPicker-Body']  //div/p"));
		
		for(WebElement e: daysValList) {
			
			if(e.getText().equals("28")) {
				e.click();
				break;
			}
			
		}
		
	}

}
