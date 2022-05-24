package DynamicWaitConcepts;

import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWaitConcept {

	public static void main(String[] args) {
	
		WebDriver driver = WebDriverManager.chromedriver().create();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit']");
		
//		getElementwithWait(driver, emailId, 6).sendKeys("dinnekumar@outlook.com");
//		driver.findElement(password).sendKeys("Happymind_90");
//		driver.findElement(loginBtn).click();
		
		System.out.println(isElementDisplayed(driver, emailId, 1));                       
		
		
		

	}
	
	public static WebElement  getElementwithWait(WebDriver driver,By locator, int timeOut) {
		
		WebElement element=null;
		for(int i=0; i<timeOut ; i++) {
			
			try {
				element =driver.findElement(locator);
				break;
			}
			catch(Exception e) {
					System.out.println("waiting for element to be present on the page " + i + "secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
				}
			}
		}
		
		return element;
		
		
	}
	
public static boolean  isElementDisplayed(WebDriver driver,By locator, int timeOut) {
		
		WebElement element=null;
		boolean flag = false;
		
		for(int i=0; i<timeOut ; i++) {
			
			try {
				element =driver.findElement(locator);
				element.isDisplayed();
				break;
			}
			catch(Exception e) {
					System.out.println("waiting for element to be present on the page " + i + "secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
				}
			}
		}
		
		return flag;
		
		
	}

}
