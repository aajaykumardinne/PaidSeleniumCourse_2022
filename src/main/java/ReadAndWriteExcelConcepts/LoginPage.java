package ReadAndWriteExcelConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");

		Thread.sleep(3000);

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement userName = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\dinne\\eclipse-workspace\\PaidSeleniumCourse_2022\\src\\main\\java\\ReadAndWriteExcelConcepts\\LoginPageData.xlsx");

		String sheetName = "LoginCredData";

		int rowCount = reader.getRowCount(sheetName);
		System.out.println(rowCount);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String loginId = reader.getCellData(sheetName, "username", rowNum);
			String password = reader.getCellData(sheetName, "password", rowNum);

			System.out.println(loginId + "\t" + password);

			userName.clear();
			userName.sendKeys(loginId);

			pass.clear();
			pass.sendKeys(password);

		}

	}

}
