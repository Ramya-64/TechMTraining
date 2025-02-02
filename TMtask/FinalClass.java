package TMtask;

import java.util.Scanner;

public class FinalClass {
	// final variable(cannot be changed)
	final int max_marks = 100;

	// final method(cannot be overridden)
	public final void grades() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your mark out of 100: ");
		int marks = sc.nextInt();
		if (marks > 50)
			System.out.println("Excellent 🥇!!!!!");
		else
			System.out.println("Good 🥈!!!!!");
		sc.close();
	}

}
