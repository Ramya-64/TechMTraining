package week2Collection;

import java.util.LinkedList;

public class InsertLinkedList_15 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

	    // Adding initial elements
	    list.add("Ramya");
	    list.add("Rithu");
	    list.add("Sri");
	    list.add("Rose");
	    list.add("Ravi");
	    
	    System.out.println("Original List: "+list);
	    
	    list.add(1,"Ramesh");
	    System.out.println("Updated List: "+list);
	}

}
