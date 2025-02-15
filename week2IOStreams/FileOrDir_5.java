package week2IOStreams;

import java.io.File;

public class FileOrDir_5 {
	public static void main(String[] args) {
		String path="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\CalcImp.java";
		File exists=new File(path);
		if(exists.isDirectory())
			System.out.println("The specified path is a directory");
		else if(exists.isFile())
			System.out.println("The specified path is a file");
		else
			System.out.println("The specified path doesn't exixts");
	}

}
