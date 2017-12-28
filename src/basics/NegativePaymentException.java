package basics;

public class NegativePaymentException extends Exception {
	
	double payment; 
	
	public NegativePaymentException(double payment) {
		this.payment = payment;
		System.out.println("Error: Negative Payment");
	}
	
	public String toString() {
		return "Error: Cannot take negative payment " + payment;
	}
}
