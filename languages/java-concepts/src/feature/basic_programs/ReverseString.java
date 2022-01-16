package feature.basic_programs;

public class ReverseString {

	public static void main(String[] args) {
		String reverse = "This String need to be reversed.";
		
		System.out.println(reverseWithIndex(reverse)); // reverse letters
		reverseWithSubstring(reverse); // reverse words
	}

	private static void reverseWithSubstring(String reverse) {
		String[] wordsArray = reverse.split("\\s");
		for(int i=wordsArray.length-1; i>=0; i--) {
			System.out.print(wordsArray[i]+" ");
		}
		
	}

	private static String reverseWithIndex(String reverse) {
		// TODO Auto-generated method stub
		int length = reverse.length();
		String updatedString = "";
		for(int i = length-1; i>=0; i--) {
			updatedString = updatedString + reverse.charAt(i);
		}
		return updatedString;
	}
}
