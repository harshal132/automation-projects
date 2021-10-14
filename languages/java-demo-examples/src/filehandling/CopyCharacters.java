package filehandling;

import java.io.*;

public class CopyCharacters {
	public static void main(String[] args) {
		 
		try(FileReader inputStream = new FileReader("aa.txt");
			FileWriter outputStream = new FileWriter("cc.txt");){
			
			int c;
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
