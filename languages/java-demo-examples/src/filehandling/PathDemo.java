package filehandling;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

	public static void main(String[] args) {
		Path javaHome = Paths.get("C:/Program Files/Java/jdk1.8.0_202");
		System.out.println(javaHome.getNameCount()); //3 doesn't count root
		System.out.println(javaHome.getRoot()); // C:\
		System.out.println(javaHome.getName(0));// Program Files
		System.out.println(javaHome.getName(1)); // Java
		System.out.println(javaHome.getFileName()); //jdk1.8.0_25
		System.out.println(javaHome.getParent());
	}
}
