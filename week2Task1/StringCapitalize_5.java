package week2Task1;

import java.util.Scanner;

public class StringCapitalize_5 {
	public static String alternateCapitalize(String name) {
		StringBuilder answer=new StringBuilder();
		for(int i=0;i<name.length();i++) {
			if(i%2==0)
				answer.append(Character.toUpperCase(name.charAt(i)));

		    else
		    	answer.append(Character.toLowerCase(name.charAt(i)));
		}
		return answer.toString();
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        String output = alternateCapitalize(input);
        System.out.println("Capitalized String: " + output);
	}
}
