package june28;

class Child implements Runnable{
	public Thread t;
	
	public Child(String name) {
		t = new Thread(this, name);
		t.start();
	}
	
	public void run() {
		System.out.println("\n\t " + Thread.currentThread().getName() + " Started!..");
		for(int j=0; j<=10; j++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n\t\t "+ Thread.currentThread().getName() +"  =  " + j);
		}
		System.out.println("\n\t " + Thread.currentThread().getName() + " Ended!..");
	}
}

public class ThreadMethodsDemo {

	public static void main(String[] args) {
		
		System.out.println("\n\t Main Thread Started!...");
		
		Child t1 = new Child("t1");
		Child t2 = new Child("t2");
		
		try {
			t1.t.join();
			t2.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\t Main Program Ended!...");
		
	}
}
