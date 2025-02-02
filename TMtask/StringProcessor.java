package TMtask;
public class StringProcessor {

    // Method to reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method to count occurrences of a substring
    public static int countOccurrences(String text, String sub) {
        int count = 0, index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); 
        }
        return count;
    }

    // Method to split string by spaces and capitalize 
    public static String splitAndCapitalize(String str) {
        String[] words = str.split("\\s+"); 
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))) 
                      .append(word.substring(1).toLowerCase()) 
                      .append(" ");
            }
        }
        return result.toString().trim(); // Remove extra spaces
    }

    public static void main(String[] args) {
        // Test reverseString method
        String input = "Ramya is selected in TechMahindra";
        System.out.println("Reversed: " + reverseString(input)); 

        // Test countOccurrences method
        String text = "TechM TechMahindra Tech Mahindra";
        String sub = "Tech";
        System.out.println("Occurrences: " + countOccurrences(text, sub)); 

        // Test splitAndCapitalize method
        String sentence = "tech mahindra java-fsd";
        System.out.println("Capitalized: " + splitAndCapitalize(sentence)); 
	    }
	}

