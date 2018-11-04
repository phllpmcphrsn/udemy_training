package labs;

public class BankAccountApp {


	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("1234567", 500);
		BankAccount acc2 = new BankAccount("1847659", 1200);
		BankAccount acc3 = new BankAccount("7481974", 100);
		BankAccount acc4 = new BankAccount("8941872", 5380250);
		
		acc1.setName("Bob");
		acc1.makeDeposit(2000);
		acc1.accrue();
		System.out.println(acc1.toString());
		
		acc2.setName("Jim");
		acc2.payBill("water", 100);
		System.out.println(acc2.toString());
		
		acc3.setName("Elisha");
		acc3.makeDeposit(4300);
		acc3.payBill("gas", 250);
		acc3.accrue();
		System.out.println(acc3.toString());
		
		acc4.setName("Elisha");
		acc4.makeDeposit(4300);
		acc4.payBill("electric", 250);
		acc4.withdraw(200000.00);
		acc4.accrue();
		System.out.println(acc4.toString());
	}

}
