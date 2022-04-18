package feature.basic_programs;
//access global variables
public class GlobalVariables {
	int a = 10;
	public static void main(String[] args) {
		int a = 10;
		System.out.println(new GlobalVariables().a+a);

	}
}
