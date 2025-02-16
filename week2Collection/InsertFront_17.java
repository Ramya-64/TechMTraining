package week2Collection;

import java.util.LinkedList;

public class InsertFront_17 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

	    // Adding initial elements
	    list.add("Ramya");
	    list.add("Rithu");
	    list.add("Sri");
	    list.add("Rose");
	    list.add("Ravi");
	    
	    System.out.println("Original List: "+list);
	    
	    list.addFirst("Hi");
	    System.out.println("Updated List: "+list);
	}

}
