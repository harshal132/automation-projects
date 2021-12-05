package com.automation.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadAPIResponse {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		URL url;
			url = new URL("https://www.browserstack.com/list-of-browsers-and-platforms.json?product=automate");
			String temp ="";
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		if(conn.getResponseCode() != 200) {
			System.out.println("Response code other than 200");
		}
		else {
			Scanner scan = new Scanner(url.openStream());
			System.out.println("Reading API data");
			while(scan.hasNext()) {
				temp = temp + scan.nextLine();
		    }
			System.out.println("Data From API");
			//System.out.println(temp);
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject)parse.parse(temp);
			JSONArray desktopArray = (JSONArray) jobj.get("desktop");
			JSONArray mobileArray = (JSONArray) jobj.get("mobile");
			scan.close();
			
			// Question 1
			JSONObject windowsObject = (JSONObject) desktopArray.get(0);
			JSONArray windowsBrowsers = (JSONArray) windowsObject.get("browsers");
			 for (int i = 0; i< windowsBrowsers.size();i++) {
				 JSONObject diffBrowsers = (JSONObject) windowsBrowsers.get(i);
				 if(diffBrowsers.get("browser").equals("chrome")) {
					 System.out.println("Latest Chrome Browser Version = "+diffBrowsers.get("browser_version"));
					 break;
				 }
			 }
			 
			 //Question 2
			 for (int i = 0; i< windowsBrowsers.size();i++) {
				 JSONObject diffBrowsers = (JSONObject) windowsBrowsers.get(i);
				 if(diffBrowsers.get("browser").equals("firefox")) {
					 System.out.println("Latest Firefox Browser Version = "+diffBrowsers.get("browser_version"));
					 break;
				 }
			 }
			 
			 //Question 3
			 JSONObject iosObject = (JSONObject) mobileArray.get(0);
			 JSONArray iosDevices = (JSONArray) iosObject.get("devices");
			 for (int i = 0; i< iosDevices.size();i++) {
				 JSONObject diffDevices = (JSONObject) iosDevices.get(i);
				 if(diffDevices.get("device").equals("iPhone 8")) {
					 System.out.println("Latest iPhone 8 Version = "+diffDevices.get("os_version"));
					 break;
				 }
			 }
			 
			 
		}
	}

}
