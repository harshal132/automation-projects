package regex;

import java.util.regex.*;

public class RegExpTest {
	public static void main(String[] args) {
		String inputStr = "Test String";
		String patern = "Test String";
		boolean patternMatched = Pattern.matches(patern, inputStr);
		System.out.println(patternMatched);

		
		 Pattern pattern1 = Pattern.compile(","); 
		 String[] str = pattern1.split("Shop,Mop,Hopping,Chopping"); 
		 for (String st : str) {
		 System.out.println(st); }
		
		 
		String input = "Shop,Mop,Hopping,Chopping";
		Pattern pattern = Pattern.compile("hop");
		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.matches());
		while (matcher.find()) {
			System.out.println(matcher.group() + ": " + matcher.start() + ": "
					+ matcher.end());
		}
		
		Pattern p1=Pattern.compile("\\d+");
		String s1="May 31 June 30";
		Matcher m1=p1.matcher(s1);
		while(m1.find())
		{
			System.out.println(m1.group() + ": " + m1.start() + ": "
					+ m1.end());

		}
		
		
	}
}
