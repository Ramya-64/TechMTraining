package utility;

import java.util.Scanner;

public class FindLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// user input
		System.out.println("Enter a number: ");
		int number = sc.nextInt();
		// calling static method using class name
		System.out.println(LenOfNumber.length(number));
		sc.close();
	}

}
