package basics;
/***********************************
1. Read a credit card CSV statement
2. Creating a balance variable that calculates the running balance of the user’s account
	a. If the field says CREDIT, then add the amount to the balance
	a. If the field says DEBIT, then subtract the amount to the balance
	b. If the final amount is greater than zero, charge a 10% fee and warn the user
	b. If the final amount is zero, thank the user for their payments
	b. If the final amount is less than zero, thank the user for their payment and display their overpayment.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreditCardRead {
	
	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
		String filename = "C:\\Users\\phllp\\eclipse-workspace\\CreditCard.csv";
		String dataRow;
		BufferedReader br;
		
		try {
			//Open the file
			br = new BufferedReader(new FileReader(filename));
			
			//Read the data as long as the file is not empty
			while((dataRow = br.readLine()) != null) {
				//Append lines of data to list
				data.add(dataRow);
			}
			br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		List<String> fields = new ArrayList<String>(); //List to store values of each line in the csv file
		for(String s : data) {
			fields.add(s);
		}
		System.out.println(fields.get(1));
		calculateBalance(fields);
	}

	/****************************************************************************************
	 * Calculates the balance using BigDecimal to ensure monetary precision of each value from
	 * the fields list. The method will check to see if each String contains credit or debit
	 * and calculate the balance accordingly.
	 * @param fields List of each line from the csv file
	 ****************************************************************************************/
	private static void calculateBalance(List<String> fields) {
		Iterator<String> itr = fields.iterator();
		String fieldLine;
		BigDecimal balance = BigDecimal.ZERO;

		while(itr.hasNext()) {
			fieldLine = (String)itr.next();
			String[] line = fieldLine.split(",");

			if(fieldLine.contains("CREDIT")) {
				balance = balance.add(new BigDecimal(line[3]));
			}
			if(fieldLine.contains("DEBIT")) {
				balance = balance.subtract(new BigDecimal(line[3]));
			}
		}
		notifyUser(balance);
	}

	/******************************************************************************************
	 * Notifies user of payment details, whether or not he or she has overpaid, underpaid, or
	 * paid the right amount.
	 * @param balance Self-explanatory variable to track balance of expenses
	 ******************************************************************************************/
	private static void notifyUser(BigDecimal balance) {
		BigDecimal fee = balance.multiply(BigDecimal.valueOf(0.1));
		BigDecimal totalWithFees = BigDecimal.ZERO;
		
		if(balance.compareTo(BigDecimal.ZERO) == 1) {
			totalWithFees = balance.add(fee);
			System.out.println("You have been charged a 10% fee.");
			System.out.println("Here's your total balance before the fee: " + NumberFormat.getCurrencyInstance().format(balance));
			System.out.println("Here's your total balance after the fee: " + NumberFormat.getCurrencyInstance().format(totalWithFees));
		}
		else if(balance.compareTo(BigDecimal.ZERO) == 0 ) {
			System.out.println("You have fully paid off your debts!");
		}
		else 
			System.out.println("You have overpaid! Here's your total balance: " + NumberFormat.getCurrencyInstance().format(balance));
	}
}
