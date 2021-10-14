package thisoperator;

public class Executor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Creating object of Base 1 \n Base1 obj1=new Base1(); \n" +
				"This will not work because it is ABSTRACT!");
		//Base1 obj1=new Base1();
		System.out.println("--------------------------------------------------------------");
		System.out.println("Creating object of Base2 as: \n " +
				"Base2 obj2=new Base2();");
		  Base2 obj2=new Base2();
		System.out.println("--------------------------------------------------------------");

		System.out.println("Creating object of Base2 as: \n " +
			"Base1 obj3=new Base2();");
	      Base1 obj3=new Base2();
	    System.out.println("--------------------------------------------------------------");

        System.out.println("Creating object of Base2 as: \n " +
			"Base1 obj4=new Base2(4);");
	      Base1 obj4=new Base2(4);
		System.out.println("--------------------------------------------------------------");

        System.out.println("Creating object of Base2 as: \n " +
		"Base1 obj5=new Base2(4,2);");
        Base1 obj5=new Base2(4,2);
        System.out.println("--------------------------------------------------------------");

        System.out.println("Creating object of Base2 as: \n " +
        "Base2 obj6=new Base2(5,6);");
        Base2 obj6=new Base2(5,6);
        System.out.println("--------------------------------------------------------------");

        System.out.println("Creating object of Derived as: \n " +
        "Base1 obj7=new Derived(5,6);");
        Base1 obj7=new Derived(5,6);
        System.out.println("--------------------------------------------------------------");

        System.out.println("Creating object of Derived as: \n " +
        "Derived obj8=new Derived(5,6);");
        Derived obj8=new Derived(5,6);
        System.out.println("--------------------------------------------------------------");

	}

}
