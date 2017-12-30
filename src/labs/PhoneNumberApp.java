package labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*******************************
 *  This will read a text file and will retrieve a phone number.
 *  Valid phone number:
 *  	10 digits long
 *  	Area code cannot start in 0 or 9
 *  	There can be 911 in the phone
 *  
 *  
 * @author phllp
 *
 */

public class PhoneNumberApp {
	
	/***Simple static method to parse the contents of a phone number **/
	public static String parse(String phoneNum) {
		String areaCode = phoneNum.substring(0, 3);  //Area Code (3-digits)
		String prefix = phoneNum.substring(3, 6);	 //Prefix (3-digits after area code)
		String lineNum = phoneNum.substring(6);		 //Line Number (4-digits after prefix)
		
		return "Phone Number: " + phoneNum + ", Area Code: " + areaCode + ", Prefix: " + prefix + ", Line Number: "
		+ lineNum;
	}
	
	public static void main(String[] args) {
		String filename = "C:\\Users\\phllp\\eclipse-workspace\\PhoneNumber.txt";
		File file = new File(filename);
		String[] phoneNumbers = new String[9];
		String phoneNum = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < phoneNumbers.length; i++) {
				phoneNumbers[i] = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		} catch (IOException e) {
			System.out.println("Error: Could not read file");
		}
		
		for(int i = 0; i < phoneNumbers.length; i++) {
			phoneNum = phoneNumbers[i];
			
			try {
				if (phoneNum.length() != 10) {
					throw new TenDigitsException(phoneNum);
				}
				if (phoneNum.substring(0, 1).equals("0") || phoneNum.substring(0, 1).equals("9")) {
					throw new AreaCodeException(phoneNum);
				}
				for (int n = 0; n < phoneNum.length() - 2; n++) {
					if(phoneNum.substring(n, n+1).equals("9")) {
						if(phoneNum.substring(n+1, n+3).equals("11")) {
							throw new EmergencyException(phoneNum);
						}
					}
				}
				System.out.println(parse(phoneNum));
			}catch(TenDigitsException e) {
				System.out.println("Error: Phone number is not 10 digits");
				e.toString();
			} catch (AreaCodeException e) {
				System.out.println("Error: Invalid area code");
			} catch (EmergencyException e) {
				System.out.println("Error: Invalid 911 sequence found");
			}
		}
	}

}

class TenDigitsException extends Exception {
	String num;
	
	TenDigitsException(String num) {
		this.num = num;
	}
	
	public String toString() {
		return "TenDigitsException: " + num;
	}
}

class AreaCodeException extends Exception {
	String num;
	AreaCodeException(String num) {
		this.num = num;
	}
	
	public String toString() {
		return "AreaCodeException: " + num;
	}
}

class EmergencyException extends Exception {
	String num;
	
	EmergencyException(String num){
		this.num = num;
	}
	
	public String toString() {
		return "EmergencyException: " + num;
	}
}