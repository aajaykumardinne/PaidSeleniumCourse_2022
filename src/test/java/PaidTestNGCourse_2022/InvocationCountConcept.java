package PaidTestNGCourse_2022;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	
	// to execute the particular method any number of times
	
	@Test(invocationCount = 10)
	public void createUser() {
		System.out.println("create user test....");
	}
	

	// practical example
	// 1.for creating 100 users.
	// 2. for api testing to hit the api
}
