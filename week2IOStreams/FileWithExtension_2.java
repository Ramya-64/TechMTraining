package week2IOStreams;

import java.io.File;

public class FileWithExtension_2 {
	public static void main(String[] args) {
		String folder="C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous";
		File f=new File(folder);
		if(f.exists()&&f.isDirectory()) {
			File[] files=f.listFiles();
			System.out.println("The Folder has "+files.length+" files");
			if(files!=null && files.length!=0) {
				for(File nameWithExtension:files) {
					System.out.println(nameWithExtension.getName());
				}
			}
		}	
	}
}
