package PracticeSeleniumConcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreCard_Xpath {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.espncricinfo.com/series/india-tour-of-england-2021-1239527/england-vs-india-4th-test-1239546/full-scorecard");
		
		ArrayList<String> valuesList = getBatsmanContribution(driver, "Virat Kohli");
		System.out.println(valuesList);
		
	
		
	}

	
	public static ArrayList<String> getBatsmanContribution(WebDriver driver, String batsmanName) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//span[text()= '" + batsmanName +"']//ancestor::td//following-sibling::td[@class='ds-min-w-max ds-text-right']"));
		System.out.println(scoreList.size());
		
		ArrayList<String> ar = new ArrayList<String>();
		
		for(int i=0; i<scoreList.size(); i++) {
			String score = scoreList.get(i).getText();
			// System.out.println(score);
			ar.add(score);
		}
		
		return ar;
		
	}
	
	
	
}
