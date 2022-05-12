package DropDownHandle;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropDownValues {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

		Thread.sleep(5000);

		WebElement day = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Day')]"));
		WebElement month = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Month')]"));
		WebElement year = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Year')]"));

		getDropDownValues(day);
		getDropDownValues(month);
		getDropDownValues(year);

	}

	/**
	 * This method is used to get all the values from drop down
	 * 
	 * @param element
	 * @return
	 */
	public static void getDropDownValues(WebElement element) {

		System.out.println("==========================");
		Select select = new Select(element);

		List<WebElement> dropList = select.getOptions();
		System.out.println("total number of values in drop down: " + dropList.size());

		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			System.out.println(text);

		}

	}

}
