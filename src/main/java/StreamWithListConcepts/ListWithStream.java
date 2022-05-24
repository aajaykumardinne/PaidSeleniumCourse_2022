package StreamWithListConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStream {

	public static void main(String[] args) {

		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//		
//		By country = By.id("Form_submitForm_Country");
//		
//		By country_List = By.xpath("//select[@id='Form_submitForm_Country']/option");

		By links = By.tagName("a");

		List<WebElement> coun_List = driver.findElements(links);

		// stream is applicable for the List

		long startTime = System.currentTimeMillis();

//		coun_List
//		.stream()
//		.forEach(ele -> System.out.println(ele.getText())); //1798 ms
		
		coun_List
		.parallelStream()
		.forEach(ele -> System.out.println(ele.getText())); //1558ms

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
	}

}
