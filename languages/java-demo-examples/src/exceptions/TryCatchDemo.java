package exceptions;
class TryCatchDemo {

	public static void main(String a[]) {
		String str = null;
		try {
			str.equals("Hello");
		} catch(NullPointerException ne) {
			str = new String("Hello");
			System.out.println(str.equals("Hello"));
			System.out.println(ne);
			ne.printStackTrace();
		}
		System.out.println("Continuing in the program");
	}
}
