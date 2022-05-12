package PaginationConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationWithWebTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("aajaykumardinne");
		driver.findElement(By.name("password")).sendKeys("Meat@2050");
		driver.findElement(By.className("btn-small")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));

		int i=0;
		while(true) {
			if(driver.findElements(By.linkText("Tom Peter")).size() == 1) {
				selectContact("Tom Peter");
				break;
				
			}
			else {
				try {
					pages.get(i).click();
				}
				catch(Exception e) {
					System.out.println("pagination is over and did not find any contact");
					break;
				}
				pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
			}
			i++;
		}

	}

	
	public static void selectContact(String name) {
		String checkboxXpath = "(//a[text()='" + name + "']/parent::td//preceding-sibling::td//input)[1]";

		driver.findElement(By.xpath(checkboxXpath)).click();

	}

}
