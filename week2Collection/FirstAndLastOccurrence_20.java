package week2Collection;

import java.util.LinkedList;

public class FirstAndLastOccurrence_20 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

	    // Adding initial elements
	    list.add("Ramya");
	    list.add("Rithu");
	    list.add("Sri");
	    list.add("Ramya");
	    list.add("Ravi");
	    
	    System.out.println("Original List: "+list);
	    
	    String name="Ramya";
	    
	    System.out.println("First Occurence of " +name+ " is at index "+ list.indexOf(name));
	    System.out.println("Last Occurence of " +name+ " is at index "+ list.lastIndexOf(name));
	}


}
