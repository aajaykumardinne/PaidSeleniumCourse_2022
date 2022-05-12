package CustomXpath;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpathConcept {

	public static void main(String[] args) {

		// How to customise the Xpath with different ways
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		//htmltag[@attribute ='value']
//		//input[@id='username']

//		//htmltag[@attribute1 ='value1'and @attribute2='value2']
//		//input[@id='username' and @type='email']

//		//input[@class='form-control private-form__control login-email']

		// contains -- Xpath
		// used for validating the text as well .
//		//htmltag[contains(@attribute, 'value')]

//		//input[contains(@id,'username' )]
//		//input[contains(@class, 'login-email')]
//		//input[@id='username' and contains(@class,'login-email')]
//		//input[@id='username' and contains(@class,'')]

		// contains used for dynamic ids
//		<input id="test_123">
//		<input id="test_456">
//		<input id="test_789">
//		<input id="test_2376">

		// input[@contains(@id,'test_')]

		// (//input[contains(@class,'form-control')]) [1]
		// (//input[contains(@class,'form-control')]) [2]

		// (//input[contains(@class,'form-control')]) [position()=1]
		// (//input[contains(@class,'form-control')]) [position()=2]

		// (//input[contains(@class,'form-control')]) [last()]

		//(i18n-string) [1]

		// text() in Xpath
		//htmltag[text()='value of the particular text']
		//i18n-string[text()='Forgot my password']
		//i18n-string[text() ="Don't have an account?"]

		//h5[text()="That email address doesn't exist."]
		//span[text() ='Show Password']
		//span[contains(text() ,'Show Password')]
		//span[contains(text() ,'Show')]
		//span[contains(text() ,'Password')]
		//i18n-string[contains(text() ,'account')]

		//h1/i18n-string
		//i18n-string[text()='Dashboard Library']
		
		//div[text()='Aajay Kumar Dinne']
		//div[starts-with(@class,'navAccount-accountName')]
		//div[starts-with(text(),'Moonstone technologies')]
		//div[starts-with(text(),'Aajay')]
		
		
		//div[starts-with(@class, 'user-info-name')]
		//div[starts-with(text(),'Aajay')]

		//*[@id='username']
		//input[@id='username']

		//div//input -----> direct + indirect child --- 3
		//div/input ------> direct child

	}

}
