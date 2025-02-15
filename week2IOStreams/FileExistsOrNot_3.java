package week2IOStreams;

import java.io.File;

public class FileExistsOrNot_3 {
	public static void main(String[] args) {
	String path="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\CalcImp.java";
	File exists=new File(path);
	System.out.println("Path Existence: "+exists.exists() +"\nDirectory: "+ exists.isDirectory());
	}

}
