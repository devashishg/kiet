package June29;

public class Bank {

	public static final int MAX_ACCOUNT = 10;
	public static final int MAX_AMOUNT = 10;
	public static final int INITIAL_AMOUNT = 100;
	
	private Account[] accounts = new Account[MAX_ACCOUNT];
	
	public Bank() {
		for(int i=0; i<accounts.length;i++) {
			accounts[i] = new Account(INITIAL_AMOUNT);
		}
	}
	                          
	public  void transfer(int from, int to, int amount) {
		if(amount <= accounts[from].getBalance()) {
			System.out.println("transfer");
			accounts[from].withDraw(amount);
			accounts[to].deposit(amount);
			String msg = "%s transferred %d from %s to %s \t Total Balance is %d\n";
			String tname = Thread.currentThread().getName();
			System.out.printf(msg, tname, amount, from, to, getTotalBalance());
		}
	}
	
	public int getTotalBalance() {
		int total = 0;
		for(int i=0;i<accounts.length;i++) {
			total+=accounts[i].getBalance();
		}
		return total;
	}
}
