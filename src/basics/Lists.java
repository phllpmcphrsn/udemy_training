package basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Lists {

	public static void main(String[] args) {
		ArrayList<String> cities = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String city = "";
//		int i = 1;
		System.out.println("Enter some cities (type \"exit\" to stop): ");
		while(!city.equals("exit")) {
			city = scan.nextLine();
			if(!city.equals("exit"))
				cities.add(city);
		}		
		for (String c : cities) {
			System.out.println(c);
		}
	}

}
