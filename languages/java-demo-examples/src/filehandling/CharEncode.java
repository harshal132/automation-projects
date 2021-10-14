package filehandling;

/*	Reading and Writing a Java Primitive Values.

 */

import java.io.*;

class CharEncode {

	DataOutputStream outData;
	DataInputStream inData;

	public void writeFile() {

		//try with resources, with this we don't need to close opened resources explicitly 
		try (	FileOutputStream outFile = new FileOutputStream("primitive.dat");
				OutputStreamWriter writer = new OutputStreamWriter(outFile,"8859_1");
				BufferedWriter bwriter = new BufferedWriter(writer);
				PrintWriter pwriter = new PrintWriter(bwriter, true);) {

			System.out.println("Writing using encoding: "+ writer.getEncoding());
			pwriter.println(true);
			pwriter.println('A');
			pwriter.println(Byte.MAX_VALUE);
			pwriter.println(Integer.MAX_VALUE);
			pwriter.println(Math.PI);

		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public void readFile() {

		try (	FileInputStream inFile = new FileInputStream("primitive.dat");
				InputStreamReader reader = new InputStreamReader(inFile, "8859_1");
				BufferedReader breader = new BufferedReader(reader);){
			
			System.out.println("Reading using encoding: "+ reader.getEncoding());

			/*
			 * Read Java primitives values in the same order in which they were
			 * written on primiive.dat file
			 */
			boolean t1 = breader.readLine().equals("true") ? true : false;
			System.out.println(t1);

			char t2 = breader.readLine().charAt(0);
			System.out.println(t2);

			byte t3 = (byte) Integer.parseInt(breader.readLine());
			System.out.println(t3);

			int t4 = Integer.parseInt(breader.readLine());
			System.out.println(t4);

			double t5 = Double.parseDouble(breader.readLine());
			System.out.println(t5);

		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public static void main(String[] args) {

		CharEncode c1 = new CharEncode();
		c1.writeFile();
		c1.readFile();
	}
}
