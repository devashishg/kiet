package june28;

public class Racer implements Runnable {
	
	private static String WINNER;
	private String racerName;
	private Thread t;

	public Racer(String name) {
		this.racerName = name;
		t = new Thread(this, racerName);
	}
	
	public void run() {
		startRace();
	}
	
	private void startRace() {
		for(int distance=1; distance<=100; distance++) {
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(racerName + " has covered " + distance + " meters...");
			boolean result = isRaceWon(distance);
			if(result) {
				break;
			}
		}
	}
	
	private boolean isRaceWon(int distance) {
		boolean result;
		
		if(Racer.WINNER == null && distance == 100) {
			Racer.WINNER = racerName;
			System.out.println("\n\n\t " + Racer.WINNER + " Won the Race!...");
			result = true;
		}else if(Racer.WINNER == null) {
			result  = false;
		}else if(Racer.WINNER!=null) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	
	public void start() {
		t.start();
	}
}




