package week2ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

public class PositiveNumbException_4 {
    public static void readNumbersFromFile(String filePath) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0) {
                    scanner.close();
                    throw new PositiveNumberException("❌ Positive number found: " + number);
                }
                System.out.println("Read number: " + number);
            } else {
                scanner.next(); 
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        String filePath ="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\Lambdanums.java";

        try {
            readNumbersFromFile(filePath);
            System.out.println("All numbers are negative or zero.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (PositiveNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
