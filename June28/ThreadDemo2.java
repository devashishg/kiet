package june28;

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		MyThread mt1 = new MyThread();
		
		System.out.println("\n\t state of mt1 = " + mt1.getState());
		
		mt1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\t state of mt1 = " + mt1.getState());
	}
}
