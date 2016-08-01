package test4;

public class ByTheTicket {
	Ticket ticket;
	
	public ByTheTicket(int numOfTickets) {
		super();
		this.ticket = new Ticket(numOfTickets);
	}

	class Ticket {
		int numOfTickets;

		public Ticket(int numOfTickets) {
			super();
			this.numOfTickets = numOfTickets;
		}
		
		// user can buy one ticket by call this method
		// it return 0 if succeed or -1 if there got not tickets left
		public synchronized int buyOne() {
			if (0 == numOfTickets) {
				return -1;
			}
			
			numOfTickets--;
			
			return 0;
		}
	}
	
	// simulate a customer trying to buy tickets
	// to make it simple i use inner class so it can access the variable directly
	class Customer implements Runnable {

		public void run() {
			// amount of tickets the customer have got
			int amount = 0;
			String name = Thread.currentThread().getName();
			while (true) {
				if (0 == ticket.buyOne()) {
					amount++;
					System.out.println(name + " : " + "got one ticket");
				} else {//not ticket left
					break;
				}
			}
			
			// sleep a long time so other thread finish
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " : got " + amount + " ticket(s)");
		}
		
	}

	public static void main(String[] args) {
		ByTheTicket demo = new ByTheTicket(500);
		for (int i = 0; i < 5; i++) {
			new Thread(demo.new Customer()).start();
		}
	}
	
}
