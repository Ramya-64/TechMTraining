package week2IOStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadPlainTextFile_11 {
	public static void main(String[] args) {
			String filePath="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\Lambdanums.java";
			try {
	            List<String> lines = Files.readAllLines(Paths.get(filePath));

	            for (String line : lines) {
	                System.out.println(line);
	            }
	        } 
			catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	}

}
