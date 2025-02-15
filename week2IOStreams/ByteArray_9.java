package week2IOStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteArray_9 {
	public static void main(String[] args) throws IOException {
		try {
			String filePath="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\Lambdanums.java";
			byte[] fileBytes=Files.readAllBytes(Paths.get(filePath));
			System.out.println("File Conetents: "+ new String(fileBytes));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
