package testng;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {
	
	// Note: if you not give any priority then test will execute alphabetically as per method name
	// and let see if you have give priority for 2 method and no priority for 1 method
	// then non priority test will execute first then priority one

	@Test(priority = 1)
	public void one() {
		System.out.println("I am inside Test 1");
	}

	// we can give any number in priority but the small number should be execute first
	@Test(priority = -1)
	public void two() {
		System.out.println("I am inside Test 2");

	}

	@Test(priority = 1)
	public void three() {
		System.out.println("I am inside Test 3");
	}

}
