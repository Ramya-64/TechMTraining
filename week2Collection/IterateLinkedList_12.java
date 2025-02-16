package week2Collection;

import java.util.Iterator;
import java.util.LinkedList;

public class IterateLinkedList_12 {
	public static void main(String[] args) {
	LinkedList<String> list = new LinkedList<>();
	
    // Adding initial elements
    list.add("Ramya");
    list.add("Rithu");
    list.add("Sri");
   
//    for(String name:list) {
//    	System.out.println(name);
//    }
   
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
    
	}
}
