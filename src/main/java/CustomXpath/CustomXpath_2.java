package CustomXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath_2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// 1. absolute Xpath: starts from the root element to the destination element--Never use or not recommended
		// 2. relative/custome xpath:starts from the any element
		
		driver.get("https://app.hubspot.com/login");
		//Xpath-axes
		
		// 1. Following
		//div[@class='input-group']//following::input[@name='username']
		// (//div[@class='input-group']//following::input) [1]
		
		// 2.Preceding
		//input[@name='username']//preceding::div
		
		// 3.Parent --- jumping from child to the parent
		//input[@name='username']//parent::div   
		
		// 4.Child --- jumping from parent to the child
		//div[@class='input-group']//child::input[@name='username'] 
		
		// 5.Ancestor --- highest parent
		//input[@name='username']//ancestor::div[@class='container']
		
		// 6.Preceding-sibling
		// for Dynamic WebTable Handling
		//span[text()='Anil Ramesh']//ancestor::td//preceding-sibling::td//span[@class='ToggleInputWrapper__CheckboxInnerSpan-sc-1e0922u-2 hzqKzA']

		
		//Reversing Xpath:
		// traversing from child to parent -> grand parent -> super parent -> top parent in DOM
		//input[@id='username']/../../../../../../../../../..
		String text =driver.findElement(By.xpath("//input[@id='username']/../../../../..")).getAttribute("id");
		System.out.println(text);
	}

}
