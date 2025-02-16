package week2Collection;

import java.util.LinkedList;

public class IterateFrom_13 {
	public static void main(String[] args) {
	LinkedList<String> list = new LinkedList<>();

    // Adding initial elements
    list.add("Ramya");
    list.add("Rithu");
    list.add("Sri");
    list.add("Rose");
    list.add("Ravi");
    
    int startIndex = 2; 
    for (int i = startIndex; i < list.size(); i++) {
        System.out.println(list.get(i));
    }
	}
}
