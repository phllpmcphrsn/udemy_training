package labs;

public class BankAccountApp {


	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("1234567", 500);
		BankAccount acc2 = new BankAccount("1847659", 1200);
		BankAccount acc3 = new BankAccount("7481974", 100);
		
		acc1.setName("Bob");
		acc1.makeDeposit(2000);
		acc1.accrue();
		System.out.println(acc1.toString());
		
		acc2.setName("Jim");
		acc2.payBill(100);
		System.out.println(acc2.toString());
		
		acc3.setName("Elisha");
		acc3.makeDeposit(4300);
		acc3.payBill(250);
		acc3.accrue();
		System.out.println(acc3.toString());
	}

}
