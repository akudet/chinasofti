package ex15;

public class SonAndDad {

	private int numOfChilderPlaying = 0;
	
	// return num of children playing
	private synchronized int getPlaying() {
		return numOfChilderPlaying;
	}
	
	private synchronized void incPlaying() {
		numOfChilderPlaying++;
	}
	
	private synchronized void decPlaying() {
		numOfChilderPlaying--;
	}
	
	class Dad implements Runnable {

		@Override
		public void run() {
			
			try {
				while (true) {
					if (0 != getPlaying()) {
						System.out.println("Someone is playing, snooze.." + getPlaying());
						Thread.sleep(5000);
					} else {
						System.out.println("All right, let's go home");
						break;
					}
				}
			} catch (InterruptedException ie) {
				
			}
			
		}
		
	}
	
	class Son implements Runnable {
		int i;

		public Son(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			try {
				incPlaying();
				System.out.println(i + " : let's play soccer");
				while (true) {
					if (Math.random() > 0.3) {
						System.out.println(i + " : I'm going to play longer");
						Thread.sleep(1500);
					} else {
						break;
					}
				}
				System.out.println(i + " : I'm tired!");
				decPlaying();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		final int NUM_OF_CHILD = 7;
		SonAndDad sd = new SonAndDad();
		
		
		
		for (int i = 0; i < NUM_OF_CHILD; i++) {
			new Thread(sd.new Son(i)).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(sd.new Dad()).start();
	}
	
}
