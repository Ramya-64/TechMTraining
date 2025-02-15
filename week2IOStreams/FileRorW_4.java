package week2IOStreams;

import java.io.File;

public class FileRorW_4 {
	public static void main(String[] args) {
		String path="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\CalcImp.java";
		File exists=new File(path);
		System.out.println("ReadPermission: "+exists.canRead()+"\nWrite Permission: "+exists.canWrite());
	}

}
