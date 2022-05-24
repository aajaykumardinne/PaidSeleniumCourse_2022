package DropDownHandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericMethods.DropDownUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	public static void main(String[] args) throws InterruptedException {

		// Famous Interview Questions

		// Handling the drop down with out the select class

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

		Thread.sleep(5000);

		String day = "//select[starts-with(@name, 'DOB_Day')]/option";
		String month = "//select[starts-with(@name, 'DOB_Month')]/option";
		String year = "//select[starts-with(@name, 'DOB_Year')]/option";

		DropDownUtil.selectDropDownValuesWithOutSelect(driver, day, "18");
		DropDownUtil.selectDropDownValuesWithOutSelect(driver, month, "FEB");
		DropDownUtil.selectDropDownValuesWithOutSelect(driver, year, "1945");

	}

}
