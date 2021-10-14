package collections;

import java.util.*;

class Address {
	private String name;
	private String street;
	private String city;
	private String state;
	private String code;

	Address(String n, String s, String c, String st, String cd) {
		name = n;
		street = s;
		city = c;
		state = st;
		code = cd;
	}

	public String toString() {
		return name + "\n" + street + "\n" + city + " " + state + " " + code;
	}
}

class MailList {
	public static void main(String args[]) {
		//List<Address> ml = new LinkedList<Address>();
		Vector<Address> ml = new Vector<Address>();  // thread safe

		// add elements to the linked list
		ml.add(new Address("J.W. West", "11 Oak Ave", "Urbana", "IL", "61801"));
		ml.add(new Address("Ralph Baker", "1142 Maple Lane", "Mahome", "IL",
				"61853"));
		ml.add(new Address("Tom Carlton", "867 Elm St", "Champaign", "IL",
				"61820"));
		
		Enumeration<Address> en = ml.elements();
		while (en.hasMoreElements()) {
			//Object element = itr.next();
			Address element = en.nextElement();
			System.out.println(element + "\n");
		}
		System.out.println("====================");
	
		//Iterator itr = ml.iterator();
		Iterator<Address> itr = ml.iterator();
		while (itr.hasNext()) {
			//Object element = itr.next();
			Address element = itr.next();
			System.out.println(element + "\n");
		}
		System.out.println("====================");
		for(Address ad:ml)
		{
			System.out.println(ad);
		}
	}
}
