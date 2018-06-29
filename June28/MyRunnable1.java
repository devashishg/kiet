package june28;

public class MyRunnable1 implements Runnable {

	public void run() {
		
		for(int j=0; j<=10; j++) {
			System.out.println("\n\t\t "+ Thread.currentThread().getName() +"  =  " + j);
		}
	}
}
