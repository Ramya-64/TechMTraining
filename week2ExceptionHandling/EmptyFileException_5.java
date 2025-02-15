package week2ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class EmptyFileException_5 {
    public static void readFile(String filePath) throws FileNotFoundException, EmptyFileException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        if (file.length() == 0) {  
            throw new EmptyFileException("File is empty: " + filePath);
        }

        Scanner scanner = new Scanner(file);
        System.out.println("File contents:");
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\Lambdanums.java"; // Change this to your file path

        try {
            readFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }
    }
}
