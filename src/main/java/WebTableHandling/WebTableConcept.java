package WebTableHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size()-1;
		System.out.println(rowCount);

		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[7]/td[2]
		
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		//*[@id="customers"]/tbody/tr[7]/td[3]
		
		String before_xpath = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath= "]/td[1]";
		
		for(int rowNum=2 ; rowNum <= rowCount+1; rowNum++) {
			String actual_xpath = before_xpath + rowNum + after_xpath;
		//	System.out.println(actual_xpath);
			String value = driver.findElement(By.xpath(actual_xpath)).getText();
			System.out.println(value);
		}
	}

}
