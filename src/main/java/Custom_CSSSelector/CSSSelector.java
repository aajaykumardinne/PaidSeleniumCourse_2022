package Custom_CSSSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelector {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login");
		
		// cssSelectors are faster than Xpath in terms of execution
		
			//1.id: #{id-attribute value}
		// #username
		// input#username
		// input[id='username']
		// input[id='username'][type='email']
		
			//2.classname : .{classname}
		// .form-control.private-form__control.login-email
		// input.form-control.private-form__control.login-email
		// .login-email
		// input.login-email
		
			//3. text
		// input[id^='user']  --   starting text
		// input[id^='pass']
		
		// input[id$='word']   --- ending text 
		// input[id$='name']
		
		
		// input[id*='pass']  ---- contains text
		// input[id*='word']  
		// input[id*='user']
		// input[id*='name']
		
		
			//4.parent and child tag
		// div>input[id='username']
		// div>input#username
		// div.private-form__input-wrapper>input[id='username']
		
	}
	

}
