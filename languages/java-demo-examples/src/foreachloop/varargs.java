package foreachloop;

import static java.lang.System.*;

public class varargs {
	static void print(int a, int y, String... s) {
		out.println(a + "," + y);
		for (int i = 0; i < s.length; i++)
			out.print(s[i] + "\t");
		out.println();
	}

	public static void main(String[] arg) {
		print(3, 2, "java", "java 5");
		out.println("Next invoke");
		print(1, 2, "a", "b", "c", "d", "e");
	}
}
