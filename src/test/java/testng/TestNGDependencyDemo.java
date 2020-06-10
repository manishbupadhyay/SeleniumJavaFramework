package testng;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	// we can set multiple dependency.
	// we can set depends on group
	// we can use regular expression as well
	@Test(dependsOnGroups = {"smoke.*"}) //(dependsOnGroups = {"smoke"}) //(dependsOnMethods = {"test2", "test3"}, priority = 1)
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test(groups= {"smoke"}) //(priority = 2)
	public void test2() {
		System.out.println("I am inside Test 2");
	}
	
	@Test(groups= {"smoke1"}) //(priority = 2)
	public void test3() {
		System.out.println("I am inside Test 3");
	}

}
