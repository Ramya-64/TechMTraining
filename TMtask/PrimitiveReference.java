package TMtask;

public class PrimitiveReference {
    // Method to modify an integer 
    public static void modifyPrimitive(int num) {
        num += 10; // This change will not affect the original value
    }

    // Method to modify an array 
    public static void modifyArray(int[] arr) {
        arr[0] += 10; 
    }

    public static void main(String[] args) {
        // Primitive variable
        int number = 5;
        System.out.println("Before modifyPrimitive: " + number);
        modifyPrimitive(number);
        System.out.println("After modifyPrimitive: " + number); // Unchanged

        // Reference variable (array)
        int[] numbers = {5, 10, 15};
        System.out.println("Before modifyArray: " + numbers[0]);
        modifyArray(numbers);
        System.out.println("After modifyArray: " + numbers[0]); // Modified
	    }
	}

