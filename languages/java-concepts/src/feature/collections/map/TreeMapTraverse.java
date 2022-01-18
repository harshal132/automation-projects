package feature.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTraverse {
	/* Properties
	 * Java TreeMap contains values based on the key. It implements the NavigableMap interface and extends AbstractMap class.
	 * Java TreeMap contains only unique elements.
	 * Java TreeMap cannot have a null key but can have multiple null values.
	 * Java TreeMap is non synchronized.
	 * Java TreeMap maintains ascending order.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,String> map=new TreeMap<Integer,String>();//Creating HashMap    
		map.put(1,"Mango");  //Put elements in Map  
	    map.put(7,"Apple");    
	    map.put(6,"Apple");
	    map.put(3,"Banana");   
	    map.put(8,"Grapes");
	    map.put(3,"Banana");   //will not be added as key is duplicate
	    //map.put(null,"Grapes");// treehmap does not allow null key
	       
	    System.out.println("Iterating TreeMap...");  
	    for(Map.Entry m : map.entrySet()){    
	      System.out.println(m.getKey()+" "+m.getValue());    
	    }
	}

}
