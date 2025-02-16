package weeek2Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicate_4 {
	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,2,3,4,5,4,1);

        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct() 
                                             .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("List without Duplicates: " + uniqueNumbers);
	}
}
