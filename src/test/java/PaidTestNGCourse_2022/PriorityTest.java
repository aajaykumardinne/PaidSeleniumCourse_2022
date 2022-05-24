package PaidTestNGCourse_2022;

import org.testng.annotations.Test;

public class PriorityTest {
	
	// non-priority test cases based on the alphabetic order are executed first before priority test cases.
	// priority can be negative and positive integer, zero.
	
	@Test(priority=3)
	public void test1() {
		System.out.println("test1");
	}
	
	
	@Test(priority=0)
	public void test3() {
		System.out.println("test3");
	}
	
	
	@Test(priority=-1)
	public void test2() {
		System.out.println("test2");
	}
	
	@Test(priority=4)
	public void test4() {
		System.out.println("test4");
	}
	
	@Test(priority=5)
	public void test5() {
		System.out.println("test5");
	}

}
