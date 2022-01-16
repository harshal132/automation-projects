package feature.datetime;

import java.net.InetAddress;
import java.net.URL;

public class GetAddress {


	public static void main(String args[])
	{
		try{
		InetAddress ipadd = InetAddress.getByName("www.google.com");
		System.out.println("Host Name: "+ipadd.getHostName());
		System.out.println("IP Address: "+ipadd.getHostAddress());
		URL url = new URL("www.google.com"); 
		System.out.println("Host Name: "+url.getHost()); 
		System.out.println("Port: "+url.getPort());
	}catch(Exception e)
	{ 
		
	}
	}

}
