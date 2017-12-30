package basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {

	public static void main(String[] args) {
		String filename = "C:\\Users\\phllp\\eclipse-workspace\\git_tutorial.txt";
		String text = null;
		
		File file = new File(filename);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			text = br.readLine();
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found: " + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: Could not read the data: " + filename);
			e.printStackTrace();
		} finally {
			System.out.println("Finsihed reading the file");
		}
		
		System.out.println(text);
	}

}
