package week2IOStreams;

import java.io.File;

public class FileSize_8 {
	public static void main(String[] args) {
		String filePath="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous\\Lambdanums.java";
		File f=new File(filePath);
		if(f.exists()&&f.isFile()) 
		{
		long bytesSize=f.length();
		System.out.println("File zise in KB: "+bytesSize/1024.0);
		System.out.println("File zise in MB: "+bytesSize/(1024.0*1024.0));
		}
		else
			System.out.println("File doesn't exist");
		
	}
}
