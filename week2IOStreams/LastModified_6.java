package week2IOStreams;

import java.io.File;
import java.text.SimpleDateFormat;

public class LastModified_6 {
	public static void main(String[] args) {
		String path="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\CalcImp.java";
		File exists=new File(path);
		long modifiedTime=exists.lastModified();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String modifiedDate=sdf.format(modifiedTime);
		System.out.println("Last Modified: "+modifiedDate);
	}

}
