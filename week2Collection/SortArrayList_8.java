package week2Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortArrayList_8 {
	public static void main(String[] args) {
		List<Integer> ls=Arrays.asList(5,10,8,3,1,9);
		System.out.println("Original List: "+ls);
	    Collections.sort(ls);
	    System.out.println("Sorted List: "+ ls);
	}

}
