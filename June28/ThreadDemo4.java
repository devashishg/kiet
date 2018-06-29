package june28;

public class ThreadDemo4 {
	public static void main(String[] args) {
		
		new Thread() {
				public void run() {
					for(int j=0; j<=10; j++) {
						System.out.println("\n\t\t "+ Thread.currentThread().getName() +"  =  " + j);
					}
				}
		}.start();
		
		
	}
}
