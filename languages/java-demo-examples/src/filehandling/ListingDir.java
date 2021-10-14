package filehandling;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingDir {

	public static void main(String[] args) throws IOException {
		
		Path javaHome= Paths.get("C:/Program Files/Java/jdk1.8.0_202");
		DirectoryStream<Path> contents = Files.newDirectoryStream(javaHome);
		for(Path content: contents) {
			System.out.println(content.getFileName());
		}
		contents.close();
				
	}
}
