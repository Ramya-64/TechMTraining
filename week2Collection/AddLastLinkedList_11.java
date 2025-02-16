package week2Collection;

import java.util.LinkedList;
import java.util.List;

public class AddLastLinkedList_11 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

        // Adding initial elements
        list.add("Ramya");
        list.add("Rithu");
        list.add("Sri");
        
		System.out.println("Original List: " + list);
		
		list.addLast("Raju");
		System.out.println("Updated List: "+list);
	}
}
