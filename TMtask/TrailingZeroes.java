package TMtask;

import java.util.Scanner;

public class TrailingZeroes {
	public static void main(String[] args) {
		// userinput
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		// initialize answer
		int ans = 0;
		for (int i = 5; i <= number; i = i * 5) {
			// finding powers of 5 of number & adding in answer
			ans = ans + (number / i);

		}
		// printing output
		System.out.println(ans);
	}

}