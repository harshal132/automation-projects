package feature.collections.lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTraverse {
	
	/* Properties
	 * Java ArrayList class can contain duplicate elements.
	 * Java ArrayList class maintains insertion order.
	 * Java ArrayList class is non synchronized.
	 * Java ArrayList allows random access because array works at the index basis.
	 * In ArrayList, manipulation is little bit slower than the LinkedList in Java because,
	 * a lot of shifting needs to occur if any element is removed from the array list.
	 */

	public static void main(String[] args) {
		//List Declaration
		List<Integer> arrayList = new ArrayList<Integer>();
		//add elements
		arrayList.add(1);
		arrayList.add(null); // accepts null elements
		arrayList.add(2);
		
		//add element to specific position
		arrayList.add(0, 5);
		
		System.out.println(arrayList);
	}

}
