package PaidTestNGCourse_2022;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	// Duplicate annotations are not allowed

	@Test(expectedExceptions = { Exception.class })
//	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("login test..starting");
		int i = 9 / 0;
		// line 14 will not be printed and can be handled by try catch
		System.out.println("login test -ending");
	}

	// Real-Time use of expectedExceptions = Exception.class

	// 1. Demo to the client.
	// 2. when some test cases shoud throw some exception for the negative scenarios

}
