package feature.basic_programs;

public class SubstringCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String question = "001100011";
		// answer -> 0011, 0011, 01, 10, 01, 1100
		
		
		int count = substringCounter(question);
		System.out.println(count);
	}

	private static int substringCounter(String s) {
		// TODO Auto-generated method stub
		int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
	}


}
