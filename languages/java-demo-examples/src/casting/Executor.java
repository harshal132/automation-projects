package casting;

public class Executor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Base b=new Base(); //allowed
		Derived d=new Derived(); //allowed
		Base b1=new Derived(); //allowed
		//Derived d1=new Base(); //Not allowed
		Base b2=d; //Upcasting is allowed
		//Derived d2=b1; direct Downcasting not allowed
		//Derived d3=b; direct Downcasting not allowed
		Derived d2=(Derived)b1;//allowed as reference is base and object is derived
		/*
		 * Derived d3=(Derived)b;
		 * Not allowed as object b is of base class
		 * No compilation error, but will produce
		 * java.lang.ClassCastException 
		 */
		b.methodX(); //valid
		//b.methodY(); invalid
		
		d.methodX(); //valid
		d.methodY(); //valid
		
		b2.methodX(); //valid
		//b2.methodY(); invalid
	
		d2.methodX(); //valid
		d2.methodY(); //valid
		
	}

}
