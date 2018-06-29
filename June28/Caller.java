package june28;

public class Caller implements Runnable {

	Thread t;
	CallMe callme;
	String msg;
	
	public Caller(CallMe callme, String msg) {
		this.callme = callme;
		this.msg = msg;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		callme.call(msg);
	}
	
}
