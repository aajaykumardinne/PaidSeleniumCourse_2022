package AlertPopUpHandle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		// used for Javascript alerts pop ups only
		
		// alert is a javascript method on the web page
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click(); //CLICK ON SIGN IN button
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		
		// validation point
		if(text.equals("Please enter a valid user name")) {
			System.out.println("correct error message");
		}
		else {
			System.out.println("In-correct error message");
		}
		
		alert.accept(); // click on ok button
		
		alert.dismiss(); // click on cancel button
		
	}

}
