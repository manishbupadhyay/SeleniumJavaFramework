package testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

// we can also ignore test case at package level
// if you want to ignore  all test case then you can mention at class label
//@Ignore
public class TestNGIgnoreDemo {

	//@Ignore
	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
	}

}
