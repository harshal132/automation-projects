package feature.collections.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTraverse {
	/* Properties
	 * Java LinkedHashSet class contains unique elements only like HashSet.
	 * Java LinkedHashSet class provides all optional set operation and permits null elements.
	 * Java LinkedHashSet class is non synchronized.
	 * Java LinkedHashSet class maintains insertion order.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <String> linkedHashSet = new LinkedHashSet<String>(); // create a Treeset object

		linkedHashSet.add("One");
		linkedHashSet.add("Two");
		linkedHashSet.add("Three");
		linkedHashSet.add("Three"); //only 1 object with value 'Three' will be stored, does not throw any exceptions
		linkedHashSet.add("Four");
		linkedHashSet.add("Five");
		linkedHashSet.add(null); //-- linkedhashset accepts null elements
		
		System.out.println("Contents of HashSet");
		Iterator<String> iterator = linkedHashSet.iterator(); // obtaining iterator object
		while (iterator.hasNext()) { // to iterate thru collection.
			System.out.print(iterator.next() + "\t");
		}
	}

}
