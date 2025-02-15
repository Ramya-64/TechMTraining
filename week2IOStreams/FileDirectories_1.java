package week2IOStreams;

import java.io.File;

public class FileDirectories_1 {
	public static void main(String[] args) {

		String dirPath = "C:\\Users\\Rithu\\eclipse-workspace\\dummyProject\\src\\Anonymous";

		File directory = new File(dirPath);

		if (directory.exists() && directory.isDirectory()) {

			String[] fileList =directory.list();
			System.out.println(fileList.length);

			if (fileList != null && fileList.length > 0) {
				System.out.println("Files and Directories in: " + dirPath);
				for (String fileName : fileList) {
					System.out.println(fileName);
				}
			} else {
				System.out.println("The directory is empty.");
			}
		} else {
			System.out.println("Invalid directory path or directory does not exist.");
		}
	}
}
