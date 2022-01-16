package feature.datetime;

import java.io.*;
import java.net.*;

public class CalculateClient{
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws Exception{
		Socket clientsoc = new Socket(InetAddress.getLocalHost(), 4000); 
		System.out.println("Enter the inputs");
		PrintWriter out = new PrintWriter(clientsoc.getOutputStream(), true); 
		BufferedReader in = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
		String userinput;
		try{
			while (true){
				do{
					userinput = stdin.readLine(); out.println(userinput);
				}while(!userinput.equals(".")); 
				System.out.println("Addition of 2 numbers is: " + in.readLine());
			}
		}
		catch(Exception e){
			System.exit(0);
		}
	}
}