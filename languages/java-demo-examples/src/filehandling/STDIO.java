package filehandling;

//	Reading and Writing on Standard Input and Output 													*/

import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

class STDIO{
 
	static private BufferedReader reader;
	static private PrintWriter out;

	static {
		try	{
			reader = new BufferedReader(new InputStreamReader(System.in));		
			out	= new PrintWriter(new BufferedWriter(new FileWriter("log.out", true)));
		} catch (IOException ioe) {
					reportError(ioe);
		}

	}
	// read a line form standard input.
	public static String readLine() {

		while(true) {
			try	{
				return reader.readLine();				

			} catch (IOException ioe) {
				reportError(ioe);
			}
		}
	}

	// read an integer form standard input.
	public static int readInteger() {
		while(true) {
			try	{
				return Integer.parseInt(reader.readLine());				

			} catch (IOException ioe) {
				reportError(ioe);
			} catch (NumberFormatException nfe) {
				reportError(nfe);
			} 
		}
	}

	// read a double form standard input.
	public static double readDouble() {
		while(true) {
			try	{
				return Double.parseDouble(reader.readLine());				
			} catch (IOException ioe) {
				reportError(ioe);
			} catch (NumberFormatException nfe) {
				reportError(nfe);
			} 
		}
	}

	private static void reportError(Exception e) {
		out.println(e.getMessage());
		out.flush();
	}


	public static void main(String[] args) 	{

		System.out.println("Input your Name: ");
		String name = STDIO.readLine();
		System.out.println("Input your Age: ");
		int age = STDIO.readInteger();
		System.out.println("Input your Salary: ");
		double sal = STDIO.readDouble();
		
		NumberFormat formatter = NumberFormat.getInstance(Locale.US);
		System.out.println("Data Read Is:");
		System.out.println(name);
		System.out.println(formatter.format(age));
		System.out.println(formatter.format(sal));
	}
}
