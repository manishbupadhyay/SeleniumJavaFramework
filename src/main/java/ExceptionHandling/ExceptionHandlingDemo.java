package ExceptionHandling;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try {
			demo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// first way
		/*
		 * try { System.out.println("Hello World...!!"); int i = 1/0;
		 * System.out.println("Completed"); } catch(ArithmeticException e) {
		 * System.out.println("I am inside catch block");
		 * System.out.println("Message is :" + e.getMessage());
		 * System.out.println("Cause is :" + e.getCause()); e.printStackTrace(); }
		 * finally { System.out.println("I am inside finally block"); }
		 */
		
	}
	
	// second way
	public static void demo() throws Exception {
		System.out.println("Welcome to Exception Handling");
		// throw : we can throw exception with help of throw keyword
		//throw new ArithmeticException("Invalid operation");
		
		  int i = 1/0; 
		  System.out.println("Completed");
		 
	}
}
