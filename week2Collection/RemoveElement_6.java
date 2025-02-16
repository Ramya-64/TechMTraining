package week2Collection;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement_6 {
	public static void main(String[] args) {
        // Create an ArrayList
        List<String> colors = new ArrayList<>();

        // Adding elements
        colors.add("Blue");
        colors.add("Green");
        colors.add("White");
        colors.add("Black");

        // original list
        System.out.println("Original List: " + colors);

        
        colors.remove(2);

        // updated list
        System.out.println("Updated List: " + colors);
    }

}
