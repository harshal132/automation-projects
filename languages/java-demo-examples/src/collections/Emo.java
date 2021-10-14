package collections;
import java.util.*;
public class Emo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set  cl=new HashSet();
		//List cl=new ArrayList();
		List<String> cl=new ArrayList<String>();
		boolean added=cl.add("Ram");
		System.out.println(added);
		cl.add("Sham");
		cl.add("Krishna");
		cl.add("Arjun");
		cl.add("Sham");
	//	cl.add(100);  // new Integer(100);   primitive to wrapper object => auto boxing
		//cl.add(null);
			//	cl.add(null);
;		System.out.println(cl);
		System.out.println(cl.size());
		Collections.sort(cl);
		System.out.println(cl);
	}

}
