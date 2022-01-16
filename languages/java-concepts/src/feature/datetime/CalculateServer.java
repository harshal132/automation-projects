package feature.datetime;

import java.io.*;
import java.net.*;

class CalculateServer {
	public static void main(String args[]) throws Exception{
		@SuppressWarnings("resource")
		ServerSocket serversoc=new ServerSocket(4000); 
		Socket clientsoc = serversoc.accept();
		PrintWriter out = new PrintWriter(clientsoc.getOutputStream(), true); 
		BufferedReader in = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
		//String inputline;
		//BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			while (true){
				String s;
				int i=0,c=0;
				int [] a=new int[2]; 
				while(true){
					s=in.readLine();
					if(s.equals(".")){ 
						break;
					}
					else{
						a[i]=Integer.parseInt(s); i++;
					}
				}
				c=(a[0]+a[1]);
				s=Integer.toString(c); out.println(s);
			}
		}
		catch(Exception e){
			System.exit(0);
		}
	}
}