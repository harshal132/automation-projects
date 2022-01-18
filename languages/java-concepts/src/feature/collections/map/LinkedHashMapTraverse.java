package feature.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTraverse {
	/* Properties
	 * Java LinkedHashMap contains values based on the key.
	 * Java LinkedHashMap contains unique elements.
	 * Java LinkedHashMap may have one null key and multiple null values.
	 * Java LinkedHashMap is non synchronized.
	 * Java LinkedHashMap maintains insertion order.
	 */
	public static void main(String[] args) {
		LinkedHashMap<Integer,String> map=new LinkedHashMap<Integer,String>();//Creating HashMap    
		map.put(1,"Mango");  //Put elements in Map  
	    map.put(2,"Apple");    
	    map.put(3,"Banana");   
	    map.put(4,"Grapes");
	    map.put(3,"Banana");   //will not be added as key is duplicate
	    map.put(null,"Grapes");// linkedhashmap allows single null key
	       
	    System.out.println("Iterating LinkedHashmap...");  
	    for(Map.Entry m : map.entrySet()){    
	      System.out.println(m.getKey()+" "+m.getValue());    
	    }
	}

}
