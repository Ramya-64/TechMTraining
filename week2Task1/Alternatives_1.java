package week2Task1;

import java.util.Arrays;

public class Alternatives_1 {
	public static void main(String[] args) {
		int[] numbers= {1,2,3,4,5};
		int[] altNumbers=new int[(numbers.length+1)/2];
		int j=0;
		for(int i=0;i<numbers.length;i=i+2) {
			altNumbers[j++]=numbers[i];
			
		}
		System.out.println(Arrays.toString(altNumbers));
	}

}
