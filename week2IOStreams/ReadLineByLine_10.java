package week2IOStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadLineByLine_10 {
public static void main(String[] args) {
	try {
		String filePath="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\Lambdanums.java";
		List<String> lines=Files.readAllLines(Paths.get(filePath));
		for(String line:lines) {
			System.out.println(line);
		}
	}
	catch(IOException e) {
		System.out.println(e.getMessage());
	}
}

}
