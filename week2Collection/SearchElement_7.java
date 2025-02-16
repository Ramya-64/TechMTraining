package week2Collection;

import java.util.ArrayList;
import java.util.List;

public class SearchElement_7 {
	public static void main(String[] args) {
        // Create an ArrayList
        List<String> colors = new ArrayList<>();

        // Adding elements
        colors.add("Blue");
        colors.add("Green");
        colors.add("White");
        colors.add("Black");
      
        // search element
        String search="Blue";
        if(colors.contains(search))
        	System.out.println(search+" is found at "+colors.indexOf(search));
        else
        	System.out.println("Element is not found");
	}

}
