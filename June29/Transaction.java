package June29;

public class Transaction implements Runnable {

	private Bank bank;
	private int fromAccount; //0
	
	public Transaction(Bank bank, int fromAccount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
	}
	
	public void run() {
				
		while(true) {
			
			//to value
		    int toAccount = (int)(Math.random()*Bank.MAX_ACCOUNT);
			    if(fromAccount == toAccount)
			    		continue;    
			//amount value
			int amount = (int)(Math.random()*Bank.MAX_AMOUNT);
			
				if(amount == 0)
					continue;
				
			synchronized (bank) {
				bank.transfer(fromAccount, toAccount, amount);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
