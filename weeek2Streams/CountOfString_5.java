package weeek2Streams;

import java.util.Arrays;
import java.util.List;

public class CountOfString_5 {
	public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado", "cherry");
        char letter = 'a';
        long count = words.stream()
                          .filter(word -> word.toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                          .count();

        System.out.println("Number of words starting with '" + letter + "': " + count);
	}
}
