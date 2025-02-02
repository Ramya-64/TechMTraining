package utility;

//utility class
public class LenOfNumber {
	// static method
	public static int length(int number) {
		int len = 0;
		while (number > 0) {
			number /= 10;
			len++;
		}
		return len;
	}

}
