package weeek2Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMax_7 {
	 public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(1,2,5,3,9,0,4);

	        //maximum value
	        Optional<Integer> max = numbers.stream()
	        							   .max((a, b) -> a - b);

	        //minimum value
	        Optional<Integer> min = numbers.stream()
	        		                       .min((a, b) -> a - b);

	        max.ifPresent(value -> System.out.println("Maximum Value: " + value));
	        min.ifPresent(value -> System.out.println("Minimum Value: " + value));
	    }

}
