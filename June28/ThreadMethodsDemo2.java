package june28;

class MyClass implements Runnable{
	
	public Thread t;
	
	public MyClass() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		
		for(int i=1; i<=10; i++) {
			System.out.println("\n\t " + Thread.currentThread().getName() + "  " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("\n\t I am about to stop!...");
				return;
			}
		}
	}
}

public class ThreadMethodsDemo2 {

	public static void main(String[] args) {
		
		MyClass t1 = new MyClass();
		
		try {
			Thread.sleep(5000);
			t1.t.interrupt();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
