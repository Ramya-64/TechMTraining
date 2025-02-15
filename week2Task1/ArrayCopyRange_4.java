package week2Task1;

import java.util.Arrays;

public class ArrayCopyRange_4 {
	public static void main(String[] args) {
		        int[] originalArray = {1,2,3,4,5,6,7,8,9};

		        // Copy a range from index 2 (inclusive) to index 6 (exclusive)
		        int[] copiedArray = Arrays.copyOfRange(originalArray, 2, 6);

		
		        System.out.println("Original Array: " + Arrays.toString(originalArray));
		        System.out.println("Copied Array (Range 2 to 6): " + Arrays.toString(copiedArray));
	}
}
