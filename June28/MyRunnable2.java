package june28;

public class MyRunnable2 implements Runnable {

	private String tname;
	
	public MyRunnable2(String name) {
		this.tname = name;
		Thread t = new Thread(this, tname);
		t.start();
	}
	public void run() {
		for(int j=0; j<=10; j++) {
			System.out.println("\n\t\t "+ tname +"  =  " + j);
		}
	}
}
