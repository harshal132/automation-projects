package interfaceimplementation;

import java.util.Vector;
import java.util.Enumeration;

interface Collection {

	// variable in an interface public, static and final by default.
	int MAXIMUM = 500;

	// methods are public by default and with no implementation.
	void add(Object obj);

	void delete();

	int currentCount();

	void showContents();
}

class FIFOqueue implements Collection {

	Vector v;

	FIFOqueue() {
		System.out.println("Constructing FIFO Stack");
		v = new Vector();
	}

	public void add(Object obj) {
		v.addElement(obj);
	}

	public void delete() {
		System.out.println("Deleting First Element");
		v.remove(v.firstElement());
	}

	public int currentCount() {
		return v.size();
	}

	public void showContents() {
		Enumeration e = v.elements();
		while (e.hasMoreElements()) {
			Integer i = (Integer) e.nextElement();
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.print("\n");
	}
}

class LIFOqueue implements Collection {

	Vector v;

	LIFOqueue() {
		System.out.println("Constructing LIFO Stack");
		v = new Vector();
	}

	public void add(Object obj) {
		v.addElement(obj);
	}

	public void delete() {
		System.out.println("Deleting Last Element");
		v.remove(v.lastElement());
	}

	public int currentCount() {
		return v.size();
	}

	public void showContents() {
		Enumeration e = v.elements();
		while (e.hasMoreElements()) {
			Integer i = (Integer) e.nextElement();
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.print("\n");
	}
}

class InterfaceImplementation {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };

		/*
		 * c is a reference of type Collection pointing to an object of type
		 * FIFOqueue class. This is possible because FIFOqueue class implements
		 * Colloction interface.
		 */

		Collection c = new FIFOqueue();

		for (int i = 0; i < arr.length; i++) {
			c.add(new Integer(arr[i]));
		}
		System.out.println("The current Stack Size is:" + c.currentCount());
		c.delete();
		c.showContents();

		/*
		 * The same opearation is performed on LIFOqueue object. But the results
		 * are different, cause the way LIFOqueue impements delete method is not
		 * exactly same as FIFOqueue class.
		 */
		c = new LIFOqueue();
		for (int i = 0; i < arr.length; i++) {
			c.add(new Integer(arr[i]));
		}
		System.out.println("The current Stack Size is:" + c.currentCount());
		c.delete();
		c.showContents();
	}
}
