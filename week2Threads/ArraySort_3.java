package week2Threads;

import java.util.Arrays;

class SortThread extends Thread {
	private int[] arr;

	public SortThread(int[] arr) {
		this.arr = arr;
	}

	public void run() {
		Arrays.sort(arr);
	}

	public int[] getSortedArray() {
		return arr;
	}
}

public class ArraySort_3 {
	public static void main(String[] args) {
		int[] arr = { 12, 3, 7, 8, 5, 19, 2, 6, 11, 4 };
		int mid = arr.length / 2;

		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		SortThread t1 = new SortThread(left);
		SortThread t2 = new SortThread(right);

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		int[] sortedArray = merge(t1.getSortedArray(), t2.getSortedArray());

		System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
	}

	private static int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			merged[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
		}
		while (i < left.length)
			merged[k++] = left[i++];
		while (j < right.length)
			merged[k++] = right[j++];

		return merged;
	}
}
