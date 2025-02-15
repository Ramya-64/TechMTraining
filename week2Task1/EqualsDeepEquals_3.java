package week2Task1;

import java.util.Arrays;

public class EqualsDeepEquals_3 {
	public static void main(String[] args) {
		
		//Integer comparison
		Integer a = 10;
		Integer b = 10;

		System.out.println("Using equals(): " + a.equals(b));
		System.out.println("Using deepEquals(): " + Arrays.deepEquals(new Integer[] { a }, new Integer[] { b })); // true

		//String comparison
		String[] arr1 = { "Hello", "World" };
		String[] arr2 = { "Hello", "World" };

		System.out.println("Using equals(): " + arr1.equals(arr2));
		System.out.println("Using deepEquals(): " + Arrays.deepEquals(arr1, arr2));
	}
}
