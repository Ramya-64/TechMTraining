package week2Collection;

import java.util.ArrayList;
import java.util.List;

public class RetriveElement_4 {
	public static void main(String[] args) {
        // Create an ArrayList
        List<String> colors = new ArrayList<>();

        // Adding elements
        colors.add("Blue");
        colors.add("Green");
        colors.add("White");
        colors.add("Black");

        System.out.println("Element at 3rd index: "+colors.get(3));
    }
}