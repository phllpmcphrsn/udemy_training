package basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

	public static void main(String[] args) {
		List<String[]> data = new ArrayList<String[]>();
		String filename = "C:\\Users\\phllp\\eclipse-workspace\\Accounts.csv";
		String dataRow;
		BufferedReader br;
		
		try {
			//Open the file
			br = new BufferedReader(new FileReader(filename));
			
			//Read the data as long as the file is not empty
			while((dataRow = br.readLine()) != null) {
				//Parse the data
				String[] line = dataRow.split(",");
				//Append data to list
				data.add(line);
			}
			
			br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String[] account : data) {
			System.out.print("[ ");
			for(String field : account) {
				System.out.print(field + " ");
			}
			System.out.println(" ]");
		}
	}

}
