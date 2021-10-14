package parse_data;

import java.util.Scanner;

public class ParseString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner("1:2:3:4:5:6:7:8").useDelimiter(":");
		while (scanner.hasNextInt()) {
			int num = scanner.nextInt();
			if (num % 2 == 0) {
				System.out.println(num);
			}
		}
		scanner.close();
	}
}
