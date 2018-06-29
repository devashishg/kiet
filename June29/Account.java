package June29;

public class Account {

	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public void withDraw(int amount) {
		this.balance = this.balance - amount;
	}
	
	public void deposit(int amount) {
		this.balance+=amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
}
