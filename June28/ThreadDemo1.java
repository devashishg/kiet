package june28;

public class ThreadDemo1 {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();
		
		Thread t1 = new Thread() {
			public void run() {
				for(int i=1; i<=10; i++) {
					System.out.println(Thread.currentThread().getName() + " - " + i);
				}
			}
		};
		
		t1.start();
		
		for(int i=1; i<=10; i++) {
			System.out.println(t.getName() + " - " + i);
		}
	}
}
