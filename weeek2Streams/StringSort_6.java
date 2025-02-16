package weeek2Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSort_6 {
	public static void main(String[] args) {
	  List<String> words = Arrays.asList("banana", "apple", "cherry", "mango", "grape");

      // Sort in ascending order
      List<String> ascendingOrder = words.stream()
                                         .sorted()
                                         .collect(Collectors.toList());

      // Sort in descending order
      List<String> descendingOrder = words.stream()
                                          .sorted((s1, s2) -> s2.compareTo(s1))
                                          .collect(Collectors.toList());

      System.out.println("Original List: " + words);
      System.out.println("Ascending Order: " + ascendingOrder);
      System.out.println("Descending Order: " + descendingOrder);
	}
}
