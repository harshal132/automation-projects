package filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyCopyFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
int ch;
		try(FileInputStream fis=new FileInputStream("bh.txt")){
		//try{	
		//	FileInputStream fis=new FileInputStream("bh.txt");
			while(( ch=fis.read())!=-1){
				System.out.println((char)ch);
			}
		}
		
		
		
		
	}

}
