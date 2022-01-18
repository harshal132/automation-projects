package feature.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapTraverse {
	/* Properties
	 * Java HashMap contains values based on the key.
	 * Java HashMap contains only unique keys.
	 * Java HashMap may have one null key and multiple null values.
	 * Java HashMap is non synchronized.
	 * Java HashMap maintains no order.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
		map.put(1,"Mango");  //Put elements in Map  
	    map.put(2,"Apple");    
	    map.put(3,"Banana");   
	    map.put(4,"Grapes");
	    map.put(3,"Banana");   //will not be added as key is duplicate
	    map.put(null,"Grapes");// hashmap allows single null key
	       
	    System.out.println("Iterating Hashmap...");  
	    for(Map.Entry m : map.entrySet()){    
	      System.out.println(m.getKey()+" "+m.getValue());    
	    }  
	}

}
