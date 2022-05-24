package Custom_CSSSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelector_Part2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");
		
		// 5. htmltag[attribute ='value']
			// input[name='username']
			
		
		// 6. first-of-type
			// ul#categories>li:first-of-type
		
		
		// 7. last of type
		   // ul#categories>li:last-of-type
		
		// 8. nth of type
		  // ul#categories>li:nth-of-type(5)
		  // ul#categories>li:nth-of-type(10)
		  // ul#categories>li:nth-of-type(n) -- all the elements.
	
	
		// 9. sibling of the element
			//div.navbar-header+div
		 	// div.navbar-header+div.collapse.navbar-collapse
		
		// 10. comma
			// div.private-form__input-wrapper , #username (not prefered)
		
		
		// 11. not operator
			// input.form-control.private-form__control:not(.login-password)
		

	}

}
