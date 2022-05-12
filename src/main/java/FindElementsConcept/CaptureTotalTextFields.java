package FindElementsConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTotalTextFields {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		
//		List<WebElement> textfieldList = driver.findElements(By.tagName("input"));
		
		// driver.findElements concept can be used with Xpath locator
		List<WebElement> textfieldList = driver.findElements(By.xpath("//input[@type='password']"));
		
		System.out.println(textfieldList.size());
		
		for(int i=0; i<textfieldList.size() ; i++) {
			textfieldList.get(i).sendKeys("Automation");
		}


	}

}
