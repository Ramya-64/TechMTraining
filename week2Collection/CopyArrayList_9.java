package week2Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyArrayList_9 {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(5, 10, 8, 3, 1, 9);
		System.out.println("Original List: " + ls);
		List<Integer> copy = new ArrayList<Integer>(ls);
		System.out.println("Copied List: " + copy);
	}
}
