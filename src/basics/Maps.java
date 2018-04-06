package basics;

import java.util.HashMap;
import java.util.Scanner;

public class Maps {

	public static void main(String[] args) {
		HashMap<String, String> login = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		String username, password;
		
		System.out.println("Please enter your login information...");
		System.out.print("Username: ");
		username = scan.next();
		System.out.print("Password: ");
		password = scan.next();
		
		login.put(username, password);
		
		System.out.println(login.keySet()+" "+login.values());
		
		//Create exceptions
		//Create a criteria
		// 

	}

}
