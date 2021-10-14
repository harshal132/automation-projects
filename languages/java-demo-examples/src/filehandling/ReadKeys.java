package filehandling;

import java.io.IOException;


class ReadKeys {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer();
		char c;
		System.out.println("Enter a String:");
		try {
			while ((c = (char) System.in.read()) != '\n') {
				sb.append(c);
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		String s = new String(sb);
		System.out.println("You entered : " + s);
	}
}