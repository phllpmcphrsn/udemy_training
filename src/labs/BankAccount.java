package labs;

public class BankAccount implements Interest{
	//Properties of a bank account
	private static int ID = 1000;     	//Internal ID
	private String accountNumber;		//ID + random 2-digit number + first 2 of SSN
	private static final String routingNumber = "005400657";  //constant (final); belongs to the class(static)
	private String name;
	private String SSN;
	private double balance;
	
	public BankAccount(String ssn, double initDeposit) {
		balance = initDeposit;
		this.SSN = ssn;
		ID++;
		setAccountNumber();
	}
	
	private void setAccountNumber() {
		int random = (int)(Math.random() * 100);
		accountNumber = ID +""+ random + SSN.substring(0, 2);
		System.out.println("Your Account Number: " + accountNumber);
	}
	
	public void payBill(String bill, double amount) {
		balance -= amount;
		System.out.println("Paying " + bill + " bill: " + amount);
		showBalance();
	}

	public void makeDeposit(double amount) {
		balance += amount;
		System.out.println("Making deposit: " + amount);
		showBalance();
	}
	
	void withdraw(double amount) {
		balance -= amount;
		System.out.println("Making withdraw: " + amount);
		showBalance();
	}
	
	private void showBalance() {
		System.out.println("Balance: " + balance);
	}
	
	public void accrue() {
		balance *= (1 + rate/100);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "[Name: " + name + "]\n[Account Number: " + accountNumber 
				+ "]\n[Routing Number: " + routingNumber + "]\n[Balance: " + balance + "]\n";
	}
}
