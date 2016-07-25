package ex16;

import java.util.*;

public class ThreadJoin {

	class Worker implements Runnable {
		
		// the ability to run faster
		// a higher value means it run fast
		int potential;
		
		public Worker() {
			potential = (int) Math.ceil(300 * Math.random());
		}
		
		public int getPotential() {
			return potential;
		}

		public void setPotential(int potential) {
			this.potential = potential;
		}

		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				System.out.println(name + " : round " + i);
				try {
					Thread.sleep(1000 - potential);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(name + " : finished");
		}
	}
	
	public static void main(String[] args) {
		List<Thread> workers = new ArrayList<Thread>();
		
		System.out.println("Welcome to the 9th Jintong runner chamipionship");
		ThreadJoin tj = new ThreadJoin();
		for (int i = 0; i < 5; i++) {
			workers.add(new Thread(tj.new Worker(), "W" + i));
		}
		
		new Scanner(System.in).nextLine();
		System.out.println("Starting !!!!");
		for (Thread t : workers) {
			t.start();
		}
		
		for (Thread t : workers) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("All workers finished");
	}
}
