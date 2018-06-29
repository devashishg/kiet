package june28;

public class CallMe {

	public synchronized void call(String msg) {
		System.out.print(" [ " + msg);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" ] ");
	}
}
