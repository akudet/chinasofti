package ex16;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ProConDemo {
	
	List<Character> chars = new LinkedList<Character>();
	Random rgen = new Random();
	
	class Consumer implements Runnable {
		@Override
		public void run() {
			while (true) {
				if (chars.size() > 3) {
					System.out.println("There got more than 3 left");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				char ch = nextChar();
				System.out.println("produce a <" + ch + ">");
				
				synchronized (chars) {
					chars.add(ch);
					chars.notifyAll();
				}
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		private char nextChar() {
			char c = (char) ('a' + rgen.nextInt(26));
			if (rgen.nextBoolean()) {
				// flip case
				c = Character.toUpperCase(c);
			}
			return c;
		}
	}
	
	class Producer implements Runnable {
		@Override
		public void run() {
			while (true) {
				char ch = 0;
				synchronized (chars) {
					if (chars.isEmpty()) {
						try {
							chars.wait();
							System.out.println("wake up do nothing");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						ch = chars.remove(0);
					}
				}
				
				// here it do things not that properly
				// but it's how they demo go, so I'm not going to modify it
				if (0 == ch) {//wake up by notify
					continue;
				} else {
					System.out.println("got a <" + ch + ">");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ProConDemo pcd = new ProConDemo();
		Thread p = new Thread(pcd.new Producer());
		Thread c1 = new Thread(pcd.new Consumer());
		Thread c2 = new Thread(pcd.new Consumer());
		p.start();
		c1.start();
		c2.start();
	}
	
}
