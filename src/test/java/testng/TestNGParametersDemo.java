package testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters("MyName")
	// we can mark parameter as optional. Also we can set default value
	public void test(@Optional("Aadi") String name) {
		System.out.println("My name is: " + name);
	}
}
