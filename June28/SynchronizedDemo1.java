package june28;

public class SynchronizedDemo1 {

	public static void main(String[] args) {
		
		CallMe prakhar = new CallMe();
		
		Caller caller1 = new Caller(prakhar, "Hi How are you?");
		Caller caller2 = new Caller(prakhar, "Hi Where are you?");

	}
}
