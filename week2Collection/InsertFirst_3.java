package week2Collection;

import java.util.ArrayList;
import java.util.List;

public class InsertFirst_3 {
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

	        
	        colors.add(0, "Purple");

	        // updated list
	        System.out.println("Updated List: " + colors);
	    }
	}