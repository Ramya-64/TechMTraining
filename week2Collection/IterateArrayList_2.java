package week2Collection;

import java.util.ArrayList;
import java.util.List;

public class IterateArrayList_2 {
	public static void main(String[] args) {
       
		//create list
        List<String> fruits = new ArrayList<>();

        // Add elements 
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Mango");
        fruits.add("Elderber");

        // iterate using for loop
        System.out.println("Using for loop:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
	}

}
