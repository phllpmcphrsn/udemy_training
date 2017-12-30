package basics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

	public static void main(String[] args) {
		String filename = "C:\\Users\\phllp\\eclipse-workspace\\FileToWrite.txt";
		String message = "I'm writing data that will be placed in a file.";
		
		File file = new File(filename);
		
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write(message);
			
			fw.close();
		} catch (IOException e) {
			System.out.println("Could not read file" + filename);
			e.printStackTrace();
		} finally {
			System.out.println("Closing the filewriter.");
		}
	}

}
