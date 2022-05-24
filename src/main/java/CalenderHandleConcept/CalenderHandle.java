package CalenderHandleConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ixigo.com/");
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder ='Depart' and @type ='text'] ")).click();

		Thread.sleep(5000);
		

//		String departMonthVal = driver.findElement(By.xpath("(//div[@class = 'rd-month-label']) [1]")).getText();
//		
//		while(!departMonthVal.equals("July 2022")) {
//			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow u-rotate-180 rd-back']) [1]")).click();
//			departMonthVal = driver.findElement(By.xpath("(//div[@class = 'rd-month-label']) [1]")).getText();
//		}

		// departure date
		List<WebElement> departDateList = driver
				.findElements(By.xpath("(//div[@class='rd-month']) [1]/table//div[contains(@class ,'day')]"));

		for (WebElement e : departDateList) {

			if (e.getText().equals("25")) {
				e.click();
				break;
			}

		}

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@placeholder ='Return' and @type ='text'] ")).click();

		Thread.sleep(5000);
		
		String returnMonthVal = driver.findElement(By.xpath("(//div[@class = 'rd-month-label']) [2]")).getText();
		
		while(!returnMonthVal.equals("April 2023")) {
			driver.findElement(By.xpath("//div[@class='rd-month']/button[@class='ixi-icon-arrow rd-next']")).click();
			returnMonthVal = driver.findElement(By.xpath("(//div[@class = 'rd-month-label']) [2]")).getText();
		}

		
		// return date
		List<WebElement> returnDateList = driver
				.findElements(By.xpath("(//div[@class='rd-month']) [4]/table//div[contains(@class ,'day')]"));

		for (WebElement e : returnDateList) {

			if (e.getText().equals("18")) {
				e.click();
				break;
			}

		}

	}

}
