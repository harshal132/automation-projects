package objectcreation;

public class Derived extends Base2 {

	public Derived() {
		System.out.println("Default Constructor in DERIVED CLASS");

	}

	public Derived(int i, int j) {
		System.out.println("Constructor with 2 int args in DERIVED, i is "+i + "and j is "+j);
	}

	public Derived(int i) {
		System.out.println("Constructor with int arg in DERIVED, i is "+i);
	}

}
