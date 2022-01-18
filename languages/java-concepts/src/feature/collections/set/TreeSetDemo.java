package feature.collections.set;

import java.util.*;

class TreeSetDemo {
	/* Properties
	 * Java TreeSet class contains unique elements only like HashSet.
	 * Java TreeSet class access and retrieval times are quiet fast.
	 * Java TreeSet class doesn't allow null element.
	 * Java TreeSet class is non synchronized.
	 * Java TreeSet class maintains ascending order.
	 */
	public static void main(String args[]) {
		TreeSet<String> treeSet = new TreeSet<String>(); // create a Treeset object

		treeSet.add("One");
		treeSet.add("Two");
		treeSet.add("Three");
		treeSet.add("Three"); // will not be added to collection due to duplication, does not throw any exceptions
		treeSet.add("Four");
		treeSet.add("Five");
		//treeSet.add(null); -- treeset does not accept null elements, hashset accepts null elements
		System.out.println("Contents of treeset");

		Iterator<String> iterator = treeSet.iterator(); // obtaining iterator object
		while (iterator.hasNext()) { // to iterate thru collection.
			System.out.print(iterator.next() + "\t");
		}
	}
}
