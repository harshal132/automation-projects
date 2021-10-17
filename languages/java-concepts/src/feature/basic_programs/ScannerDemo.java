package feature.basic_programs;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.print("What's your name? ");
	            String input = scanner.nextLine();
	            // execute until input is empty!
	            if (input.isEmpty()) {
	            	System.out.println("Input is Empty!");
	                break;
	            }
	            System.out.println("Your name is " + input + ". ");
	        }
	        scanner.close();
	        System.out.println("Good bye");
	}
}
