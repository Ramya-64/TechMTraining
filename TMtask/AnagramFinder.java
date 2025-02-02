package TMtask;

import java.util.*;

  public class AnagramFinder {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26]; 
    int[] sCount = new int[26]; 
    
    // Populate pCount with frequencies of characters in p
    for (char c : p.toCharArray()) {
        pCount[c - 'a']++;
    }

    int windowSize = p.length();
    
    // Process the first window
    for (int i = 0; i < windowSize; i++) {
        sCount[s.charAt(i) - 'a']++;
    }

    // Compare first window
    if (Arrays.equals(pCount, sCount)) {
        result.add(0);
    }

    // Slide the window
    for (int i = windowSize; i < s.length(); i++) {
        sCount[s.charAt(i) - 'a']++; 
        sCount[s.charAt(i - windowSize) - 'a']--; 

        if (Arrays.equals(pCount, sCount)) {
            result.add(i - windowSize + 1);
        }
    }
    
    return result;
}

public static void main(String[] args) {
    String s = "cbaebabacd";
    String p = "abc";
    System.out.println(findAnagrams(s, p)); 
	    }
	}


