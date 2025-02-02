package TMtask;
import java.security.DomainCombiner;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionHandling { 
	
	public static void processInput() {
		Scanner sc=new Scanner(System.in);
		try {
		System.out.println("Enter a number");
		int number=sc.nextInt();
		if(number==0) {
			throw new ArithmeticException();
		}
		double reciprocal=1.0/number;
		System.out.println("Reciprocal: "+reciprocal);
	}
	
	catch (ArithmeticException a){
		System.out.println(util.ZEROERROR);
	}
	
	catch (InputMismatchException n) {
		System.out.println(util.INVALID_INPUT);
	}
	finally {
			sc.close();
		}
	}
	public static void main(String[] args) {
		processInput();
	}
}
