package filehandling;

/*	Reading and Writing a Java Primitive Values.

*/

import java.io.*;

class JavaPrimitiveValues {

	FileOutputStream outFile;
	FileInputStream inFile;

	DataOutputStream outData;
	DataInputStream inData;
	public void writeFile() {

		try	{
			// create a file output stream.
			outFile =  new FileOutputStream("primitive.dat"); 

			// create a data output stream on top of file output stream.

			outData = new DataOutputStream(outFile);
		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public void readFile() {

		try	{
			// create a file input stream.
			inFile =  new FileInputStream("primitive.dat"); 

			// create a data outpuiin stream on top of file input stream.

			 inData = new DataInputStream(inFile);
		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public void writeContents() {

		// Write java primitives.
		try	{
			outData.writeBoolean(true);
			outData.writeChar('A');
			outData.writeByte(Byte.MAX_VALUE);
			outData.writeInt(Integer.MAX_VALUE);
			outData.writeDouble(Math.PI);
		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		} finally {
			try	{
				outData.close();				
			} catch (IOException ioe) {
				System.out.println("Exception: " + ioe);
				return;
			}

		}
	}

	public void readContents() {

		// Read java primitives in the order in which they were written.
		try	{
			System.out.println(inData.readBoolean());
			System.out.println(inData.readChar());
			System.out.println(inData.readByte());
			System.out.println(inData.readInt());
			System.out.println(inData.readDouble());
		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		} finally {
			try	{
				inData.close();				
			} catch (IOException ioe) {
				System.out.println("Exception: " + ioe);
				return;
			}
		}
	}

	public void closeFiles() {

		//close the files
		try	{
			outFile.close();
			inFile.close();
		
		} catch (IOException ioe) {
			System.out.println("Exception: " + ioe);
			return;
		}
	}

	public static void main(String[] args) 	{

		JavaPrimitiveValues  c1 = new JavaPrimitiveValues ();
		c1.writeFile();
		c1.writeContents();
		c1.readFile();
		c1.readContents();
		c1.closeFiles();
	}
}
