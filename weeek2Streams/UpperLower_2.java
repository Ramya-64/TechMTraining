package weeek2Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperLower_2 {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("Ramya","ruthu","ramesh","rosy");
	    System.out.println("Upper case: "+names.stream()
	    									   .map(s->s.toUpperCase())
	    									   .collect(Collectors.toList()));
	}
}
