package week2Generics;

public class ArrayElements_1 {
	    public static <T> boolean compareArrays(T[] array1, T[] array2) {
	        if (array1.length != array2.length) {
	            return false;  
	        }
	        
	        for (int i = 0; i < array1.length; i++) {
	            if (!array1[i].equals(array2[i])) { 
	                return false;
	            }
	        }
	        return true;  
	    }

	    public static void main(String[] args) {
	        
	        Integer[] arr1 = {1, 2, 3, 4, 5};
	        Integer[] arr2 = {1, 2, 3, 4, 5};
	        Double[] arr3 = {1.0, 2.8, 3.7, 4.5, 6.8};

	        System.out.println("arr1 == arr2: " + compareArrays(arr1, arr2)); // true
	        System.out.println("arr1 == arr3: " + compareArrays(arr1, arr3)); // false
	    }
}
