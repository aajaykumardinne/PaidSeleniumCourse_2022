package GenericMethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {

	/**
	 * This method is used to select the value from a dropdown on the basis of given
	 * text
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

	/**
	 * This method is used to select the value from a dropdown on the basis of index
	 * 
	 * @param element
	 * @param index
	 * 
	 */
	public static void selectValuefromDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * This method is used to select the value from a drop down on the basis of value
	 * @param element
	 * @param value
	 */
	
	public void selectValuefromDropDownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	
	/**
	 * This method is used to get all the values from drop down
	 * 
	 * @param element
	 * @return
	 * 
	 */
	public static ArrayList<String> getDropDownValues(WebElement element) {

		System.out.println("=====================================");
		Select select = new Select(element);

		List<WebElement> dropList = select.getOptions();
		System.out.println("total number of values in drop down: " + dropList.size());
		
		ArrayList<String> ar = new ArrayList<String>();

		for (int i = 0; i < dropList.size(); i++) {
			String text = dropList.get(i).getText();
			// System.out.println(text);
			ar.add(text);
		}

		return ar;
	}

	/**
	 * This method is used to select the values from the drop down list without  Select class
	 * @param driver
	 * @param locator
	 * @param value
	 * 
	 */
	public static void selectDropDownValuesWithOutSelect(WebDriver driver,String locator, String value) {

		List<WebElement> dropdownList = driver.findElements(By.xpath(locator));

		System.out.println("The number of drop down values : " + dropdownList.size());

		for (int i = 0; i < dropdownList.size(); i++) {
			String dropdownText = dropdownList.get(i).getText();
			System.out.println(dropdownText);
			if (dropdownText.equals(value)) {
				dropdownList.get(i).click();
				break;
			}

		}

	}

}
