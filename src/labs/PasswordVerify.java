package labs;
/**************************************************************
 * 1. Read a file that contains multiple sets of passwords
 * 2. Verify that the password contains all of the following criteria:
 *	  1. A number
 *	  2. A letter
 *	  3. Special character (! @ #)
 * 3. Create three User Defined Exceptions for the corresponding criteria.
 * 4. If the password does not meet the criteria, create and throw the appropriate exception
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PasswordVerify {
/*********************************
 * Each one of these "contain" methods treats the password as an array and 
 * checks each character to see if they meet the criteria
 * @param password - Password from text file to be parsed
 * @return
 */
	public static boolean containNumber(String password) {
		boolean result = false;
		for (char c: password.toCharArray()) {
			if(Character.isDigit(c)) {
				result = true;
			}
		}
		return result;
	}
	
	private static boolean containLetter(String password) {
		boolean result = false;
		for (char c: password.toCharArray()) {
			if(Character.isLetter(c)) {
				result = true;
			}
		}
		return result;
	}
	
	private static boolean containSpecial(String password) {
		boolean result = false;
		for (char c: password.toCharArray()) {
			if(c == '!' || c == '@' || c == '#') {
				result = true;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String filename = "C:\\Users\\phllp\\eclipse-workspace\\Passwords.txt";
		String[] pw = new String[13];    //passwords
		String password = null;
		
		File file = new File(filename);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < pw.length; i++) {
				pw[i] = br.readLine();
			}
			
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
		
		for(int i = 0; i < pw.length; i++) {
			password = pw[i];

			try {
				if (!containNumber(password)) {
					throw new NumberNotFoundException(password);
				}

				if (!containLetter(password)) {
					throw new LetterNotFoundException(password);
				}
				
				if (!containSpecial(password)) {
					throw new SpecialCharNotFoundException(password);
				}
				System.out.println(password);
			}catch(NumberNotFoundException e) {
				System.out.println(e.toString());
			} catch (LetterNotFoundException e) {
				System.out.println(e.toString());
			} catch (SpecialCharNotFoundException e) {
				System.out.println(e.toString());
			} 
		}
	}


}

class NumberNotFoundException extends Exception{
	String password;
	
	NumberNotFoundException(String pw){
		password = pw;
	}
	
	public String toString() {
		return "Invalid password: Needs to include a number";
	}
}

class LetterNotFoundException extends Exception{
	String password;
	
	LetterNotFoundException(String pw){
		password = pw;
	}
	
	public String toString() {
		return "Invalid password: Needs to include a letter";
	}
}

class SpecialCharNotFoundException extends Exception{
	String password;
	
	SpecialCharNotFoundException(String pw){
		password = pw;
	}
	
	public String toString() {
		return "Invalid password: Needs to include the following special characters (! @ #)";
	}
}