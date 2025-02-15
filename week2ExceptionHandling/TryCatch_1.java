package week2ExceptionHandling;

public class TryCatch_1 {
	public static void main(String[] args) {
		try {
			int ans=10/0;
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
			
		}
	}

}
