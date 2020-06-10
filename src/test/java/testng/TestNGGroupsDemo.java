package testng;

import org.testng.annotations.Test;

// Define group at class level

@Test(groups= {"AllClassTests"})
public class TestNGGroupsDemo {

	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("This is Test 1");
	}
	
	// we can execute this test on OS level. test2 will run on windows and it is part of regression
	@Test(groups = {"windows.regression"})
	//@Test(groups = {"sanity", "smoke"})
	public void test2() {
		System.out.println("This is Test 2");
	}
	
	@Test(groups = {"linux.regression"})
	//@Test(groups = {"sanity","regression"})
	public void test3() {
		System.out.println("This is Test 3");
	}
	
	@Test
	public void test4() {
		System.out.println("This is Test 4");
	}
}
