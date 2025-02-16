package week2Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleArrayList_10 {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1,2,3,4,5);
		System.out.println("Original List: " + ls);
		Collections.shuffle(ls);
		System.out.println("Shuffled List: " + ls);
	}

}
