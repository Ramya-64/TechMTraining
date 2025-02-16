package weeek2Streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageOfList_1 {
	public static void main(String[] args) {
		List<Integer> numbers=Arrays.asList(1,2,3,4,5);
		OptionalDouble avg=numbers.stream()
								  .mapToInt(s->s)
								  .average();
		System.out.println("Average: " + (avg.isPresent() ? avg.getAsDouble() : "No values in list"));
	}
}
