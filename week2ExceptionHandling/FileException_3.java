package week2ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileException_3 {
	public static void readFile(String path) throws IOException {
		File f=new File(path);
		if(!f.exists()) {
			throw new FileNotFoundException("File not found");
		}
		else {
			List<String> files=Files.readAllLines(Paths.get(path));
			for(String line:files) {
				System.out.println(line);
			}
		}	
	}
	public static void main(String[] args) {
		String path="C:\\rithu";
		
		try {
			readFile(path);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException i) {
			System.out.println(i.getMessage());
		}
	}

}
