package basics;

import java.util.Scanner;

public class PaymentsApp {
	public static void main(String[] args) {
		double payment = 0;
		boolean positive = true;   //control variable for do loop; positive payment
		
		//Immediately perform the following until positive is true
		//If false, continue to ask the user for proper input
		do {
			System.out.print("Enter the payment method: ");
			Scanner in = new Scanner(System.in);   //get input
			
			try { //using try instead of conditionals so the client doesn't handle exception
				payment = in.nextDouble();
				if (payment < 0 ) 
					throw new NegativePaymentException(payment);
				else
					positive = true;
			}catch (NegativePaymentException e) {
				System.out.println(e.toString());
				System.out.println("Please try again...");
				positive = false;
			}
		
		}while(!positive);
		
		System.out.println("Thank you for you payment $" + payment);
		
		
		
		
	}

}
