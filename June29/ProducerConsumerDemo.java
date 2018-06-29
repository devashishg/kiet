package June29;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		
		MessageBox box = new MessageBox();
		
		Thread producerThread = new Thread() {
				public void run() {
					System.out.println("\n\t Producer Thread started...");
					for(int i=1; i<=6;i++) {
						box.putMessage("Message " + i);
						System.out.println("\n\t Put Message " + i);
					}
				}
		};
		
		Thread consumerThread1 = new Thread() {
			public void run() {
				System.out.println("\n\t\t Consumer Thread 1 Started...");
				for(int i=1; i<=3; i++) {
					System.out.println("\n\t\t Consumer Thread 1 Get " + box.getMessage());
				}
			}
		};
		
		Thread consumerThread2 = new Thread() {
			public void run() {
				System.out.println("\n\t\t Consumer Thread 2 Started...");
				for(int i=1; i<=3; i++) {
					System.out.println("\n\t\t Consumer Thread 2 Get " + box.getMessage());
				}
			}
		};
		
		producerThread.start();
		consumerThread1.start();
		consumerThread2.start();
	}
}




