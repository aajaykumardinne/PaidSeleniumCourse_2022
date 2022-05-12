package DropDownHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

		Thread.sleep(5000);

		WebElement day = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Day')]"));
		WebElement month = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Month')]"));
		WebElement year = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Year')]"));

		Select select = new Select(day);
//		select.selectByVisibleText("18");
//		select.selectByIndex(1);

//		Select select1 = new Select(month);
//		select1.selectByVisibleText("FEB");
//		select1.selectByIndex(9);

//		Select select2 = new Select(year);
//		select2.selectByVisibleText("1995");

//		selectValuefromDropDown(day, "18");
//		
//		selectValuefromDropDown(month, "FEB");
//		selectValuefromDropDown(year, "1995");

//		selectValuefromDropDownByIndex(year, 12);
		
		

	}

	/**
	 * This method is used to select the value from a dropdown on the basis of given text
	 * 
	 * 
	 * @param element
	 * @param value
	 * 
	 **/
	public static void selectValuefromDropDownByText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	/**This method is used to select the value from a dropdown on the basis of index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectValuefromDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

}
