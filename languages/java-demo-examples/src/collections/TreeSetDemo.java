package collections;

import java.util.*;

class TreeSetDemo {
	public static void main(String args[]) {
		TreeSet<String> treeSet = new TreeSet<String>(); // create a Treeset
															// object

		treeSet.add("One");
		treeSet.add("Two");
		treeSet.add("Three");
		treeSet.add("Four");
		treeSet.add("Five");
		treeSet.add(null);
		System.out.println("Contents of treeset");

		Iterator<String> iterator = treeSet.iterator(); // obtaining iterator object
		while (iterator.hasNext()) { // to iterate thru collection.
			//Object object = iterator.next(); no object conversion required
			System.out.print(iterator.next() + "\t");
		}
	}
}
