package feature.collections.lists;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTraverse {
	
	/* Properties
	 * Java LinkedList class can contain duplicate elements.
	 * Java LinkedList class maintains insertion order.
	 * Java LinkedList class is non synchronized.
	 * In Java LinkedList class, manipulation is fast because no shifting needs to occur.
	 * Java LinkedList class can be used as a list, stack or queue.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> linkedList = new LinkedList<Integer>();
		//add elements
		linkedList.add(1);
		linkedList.add(null); // accepts null elements
		linkedList.add(2);
		
		//add element to specific position
		linkedList.add(0, 5);
		
		//get size
		System.out.println("Size of List= "+linkedList.size());
		
		//remove elements
		linkedList.remove(Integer.valueOf(10)); // --- removes object -- if not present no exception thrown
		linkedList.remove(10); // -- removes value at given index, if index not found then "IndexOutOfBoundsException" thrown
		
		System.out.println(linkedList);
	}

}
