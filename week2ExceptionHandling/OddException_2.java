package week2ExceptionHandling;

import java.util.Scanner;

public class OddException_2 {
	public static void checkNumber(int num) throws Exception {
        if (num % 2 != 0) {
            throw new Exception("Please enter even number");
        }
        System.out.println("Number " + num + " is even.");
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number=sc.nextInt();
		try {
			checkNumber(number);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
