package PaidTestNGCourse_2022;

import org.testng.annotations.Test;

public class DependsonMethodConcept {

	// verbose in .xml 
	// kind of information we are getting on the console from the Testng.
	// can take values from 1 to 10
	// recommended value 4 or 5
	
	
	@Test(priority=1)
	public void loginTest() {
		System.out.println("login test");
		
	}

	@Test(priority=2 , dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("home page test");
		int i=9/0;
	}

	@Test(priority=3, dependsOnMethods = {"loginTest", "homePageTest"})
	public void searchTest() {
		System.out.println("search test");
	}

}
