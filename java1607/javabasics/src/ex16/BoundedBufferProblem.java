package ex16;

public class BoundedBufferProblem {
	
	class Buffer {
		int size;

		public Buffer(int size) {
			super();
			this.size = size;
		}

		public synchronized int getSize() {
			return size;
		}

		public synchronized void get() {
			size--;
		}
		
		public synchronized void put() {
			size++;
		}
		
	}
	
	class Worker implements Runnable {
		Buffer b;
		Object lock;
		
		public Worker(Buffer b) {
			super();
			this.b = b;
			lock = new Object();
		}

		@Override
		public void run() {
			// it's strange if I sleep that everyone got equal amount(10 I use 100 ticket and 10 worker)
			
			String name = Thread.currentThread().getName();
			int amount = 0;
			
			while (true) {
				synchronized (lock) {
					if (0 == b.getSize()) {
						break;
					}
					b.get();
				}

				amount++;
				System.out.println(name + " : got one");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(name + " : got " + amount);
		}
	}
	
	public static void main(String[] args) {
		BoundedBufferProblem bb = new BoundedBufferProblem();
		Buffer b = bb.new Buffer(100);
		
		for (int i = 0; i < 10; i++) {
			new Thread(bb.new Worker(b), "W" + i).start();
		}
	}

}
