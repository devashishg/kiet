package june28;

public class MyThread extends Thread{

	public void run() {
		
		System.out.println("\n\t state of mt1 = " + getState());
		
		for(int j=0; j<=10; j++) {
			System.out.println("\n\t\t j = " + j);
			
		}
	}
}
