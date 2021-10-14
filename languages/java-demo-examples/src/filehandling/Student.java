package filehandling;

import java.io.*;

class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	transient int roll;
	String sname;

	public Student(int r, String s) {
		roll = r;
		sname = s;
	}

	public String toString() {
		return "Roll no is : " + roll + "   Name is : " + sname;
	}
}