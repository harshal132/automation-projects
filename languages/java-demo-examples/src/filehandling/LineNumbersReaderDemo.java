package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumbersReaderDemo {

	public static void main(String[] args) {
		String s;
		try(FileReader fr = new FileReader("aa.txt");
                BufferedReader br = new BufferedReader(fr);
                LineNumberReader lr = new LineNumberReader(br);) {
			while((s = lr.readLine()) != null)
				System.out.println(lr.getLineNumber()+" " +s);
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
                

	}
}
