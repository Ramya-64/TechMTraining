package week2Generics;

import java.util.Arrays;
import java.util.List;

public class SumOfEvenOdd_2 {
	public static <t extends Number>void sum(List<t> num){
		int even=0;
		int odd=0;
		for(t number:num) {
			int val=number.intValue();
			if(val%2==0)
				even+=val;
			else
				odd+=val;
		}
		System.out.println("Sum of even numbers: "+even);
		System.out.println("Sum of odd numbers: "+odd);
	}
	public static void main(String[] args) {
		List<Integer> num=Arrays.asList(1,2,3,4,5,6);
		sum(num);
	}

}
