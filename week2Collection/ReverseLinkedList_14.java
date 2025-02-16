package week2Collection;

import java.util.LinkedList;

public class ReverseLinkedList_14 {
	public static void main(String[] args) {
	LinkedList<String> list = new LinkedList<>();

    // Adding initial elements
    list.add("Ramya");
    list.add("Rithu");
    list.add("Sri");
    list.add("Rose");
    list.add("Ravi");
    
    for (int i = list.size()-1; i >=0; i--) {
        System.out.println(list.get(i));
    }
	}
}
