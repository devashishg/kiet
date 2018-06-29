package June29;

public class MessageBox {

	private String message;
	private boolean hasMessage;
	
	public synchronized void putMessage(String message) {
		while(hasMessage) {
			//no room for new messages
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		hasMessage = true;
		this.message = " Put @ " + System.nanoTime();
		notify();
	}
	
	public synchronized String getMessage() {
		while(!hasMessage) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hasMessage = false;
		notify();
		return message + " Get @ " + System.nanoTime();
	}
}








