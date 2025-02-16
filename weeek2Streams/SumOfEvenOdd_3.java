package weeek2Streams;

import java.util.Arrays;
import java.util.List;

public class SumOfEvenOdd_3 {
	public static void main(String[] args) {
		List<Integer> names=Arrays.asList(1,2,3,4,5);
	    int sumEven=names.stream()
	    				 .filter(s->s%2==0)
	    				 .mapToInt(s->s).sum();
	    
	    System.out.println("Sum of even number: "+sumEven);
	    
	    int sumOdd=names.stream()
	    				.filter(s->s%2!=0)
	    				.mapToInt(s->s).sum();
	    
	    System.out.println("Sum of odd numbers: "+sumOdd);
	}
}
