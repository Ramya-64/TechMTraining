package TMtask;

import java.util.Scanner;

public class Division {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(util.DIVIDEND);
		int n1 = sc.nextInt();
		System.out.println(util.DIVISOR);
		int n2 = sc.nextInt();
		if (n2 == 0) {
            System.out.println(util.ZEROERROR);
            sc.close();
            return;
        }
		int quotient = 0;
		while (n1>=n2) {
			n1 -= n2;
			quotient++;
		}
		System.out.println(util.QUOTIENT + quotient);
		System.out.println(util.REMAINDER + n1);
		sc.close();
	}

}
