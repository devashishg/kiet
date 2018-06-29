package june28;

public class ThreadDemo3 {

	public static void main(String[] args) {
		
		MyRunnable1 r1 = new MyRunnable1();
		
		Thread t1 = new Thread(r1, "T1");
		t1.start();
		
		 
		Thread t2 = new Thread(r1, "T2");
		t2.start();
	}
}
