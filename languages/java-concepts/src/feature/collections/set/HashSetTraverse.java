package feature.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTraverse {
	/* Properties
	 * HashSet stores the elements by using a mechanism called hashing.
	 * HashSet contains unique elements only.
	 * HashSet allows null value.
	 * HashSet class is non synchronized.
	 * HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
	 * HashSet is the best approach for search operations.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> hashSet = new HashSet<String>(); // create a Treeset object

		hashSet.add("One");
		hashSet.add("Two");
		hashSet.add("Three");
		hashSet.add("Three"); //only 1 object with value 'Three' will be stored, does not throw any exceptions
		hashSet.add("Four");
		hashSet.add("Five");
		hashSet.add(null); //-- hashset accepts null elements
		
		System.out.println("Contents of HashSet");
		Iterator<String> iterator = hashSet.iterator(); // obtaining iterator object
		while (iterator.hasNext()) { // to iterate thru collection.
			System.out.print(iterator.next() + "\t");
		}
		
	}

}
