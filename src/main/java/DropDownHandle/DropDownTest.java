package DropDownHandle;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

		Thread.sleep(5000);

		WebElement day = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Day')]"));
		WebElement month = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Month')]"));
		WebElement year = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Year')]"));
		
		String date = "18-FEB-1995";
		String[] dateVal =date.split("-");
		
		DropDownUtil.selectValuefromDropDownByText(day, dateVal[0]);
		DropDownUtil.selectValuefromDropDownByText(month, dateVal[1]);
		DropDownUtil.selectValuefromDropDownByText(year, dateVal[2]);

		ArrayList<String>  dayList = DropDownUtil.getDropDownValues(day);
		System.out.println(dayList);

		ArrayList<String> monthList = DropDownUtil.getDropDownValues(month);
		System.out.println(monthList);

		ArrayList<String> yearList = DropDownUtil.getDropDownValues(year);
		System.out.println(yearList);

	}

}
