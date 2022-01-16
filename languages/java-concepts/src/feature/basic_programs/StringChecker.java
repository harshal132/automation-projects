package feature.basic_programs;

public class StringChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCDEF";
		char c;
		boolean flag = true;
		int firstIndex;
		int lastIndex;
		for(int i=0;i<s1.length();i++) {
			c = s1.charAt(i);
			firstIndex = s1.indexOf(c);
			lastIndex = s1.lastIndexOf(c);
			
			if(firstIndex != lastIndex) {
				flag = false;
				break;
			}	
		}
		if(flag) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}

}
