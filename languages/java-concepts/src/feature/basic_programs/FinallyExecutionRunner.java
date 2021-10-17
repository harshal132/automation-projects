package feature.basic_programs;

public class FinallyExecutionRunner {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Main Execution started");
		Thread.sleep(2000);
		System.out.println("Going to another method");
		executeFinallyReturnScenario();
		System.out.println("Control back to Main method");
		Thread.sleep(2000);
	}

	public static int executeFinallyReturnScenario() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inside Try block");
			return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally Block Executed!");
		}
		return 0;		
	}
}

/* Output:
 *	Main Execution started
	Going to another method
	Inside Try block
	Finally Block Executed!
	Control back to Main method
*/
