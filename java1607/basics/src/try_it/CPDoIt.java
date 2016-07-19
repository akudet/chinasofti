package try_it;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CPDoIt {
	
	class Food {
		String name;
		String type;
		
		public Food(String name, String type) {
			super();
			this.name = name;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
	}
	
	class Producer implements Runnable {
		String id;
		BlockingQueue<Food> foods;
		final String[] foodsTable = {
				"Apple", "Banana", "Coco", "Grape", "Tomato",
				"Orange", "Milk", "Sugar", "Salt", "Rice"
				};
				
		public Producer(String id, BlockingQueue<Food> foods) {
			super();
			this.id = id;
			this.foods = foods;
		}

		// produce one random food, take 500ms
		private Food produceFood() throws InterruptedException {
			int idx = (int) Math.floor(Math.random() * foodsTable.length);
			String foodName = foodsTable[idx];
			String foodType = "something can eat";
			Food food =  new Food(foodName, foodType);
			System.out.println(id + " : produced " + foodName);
			Thread.sleep(300);
			return food;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					foods.put(produceFood());
				}
			} catch (InterruptedException e) {
				System.out.println(id + " : terminating");
			}
		}
		
	}
	
	class Consumer implements Runnable {
		String id;
		BlockingQueue<Food> foods;

		public Consumer(String id, BlockingQueue<Food> foods) {
			this.id = id;
			this.foods = foods;
		}

		// consume food, take 300ms
		private void consumeFoods(Food food) throws InterruptedException {
			System.out.println(id + " : eating " + food.getName());
			Thread.sleep(300);
		}

		@Override
		public void run() {

			try {
				while (true) {
					Food f = foods.take();
					consumeFoods(f);
				}
			} catch (InterruptedException e) {
				System.out.println(id + " : terminating");
			}

		}
		
	}

	
	public static void main(String[] args) {
		CPDoIt cp = new CPDoIt();
		
		final int NUM_CONSUMERS = 1;
		final int NUM_PRODUCERS = 2;
		
		//spawn consumers and producers
		BlockingQueue<Food> bq = new LinkedBlockingQueue<Food>(10);
		ExecutorService service = Executors.newCachedThreadPool();
		
		Consumer[] consumers = new Consumer[NUM_CONSUMERS];
		for (int i = 0; i < NUM_CONSUMERS; i++) {
			consumers[i] = cp.new Consumer("C " + i, bq);
		}
		Producer[] producers = new Producer[NUM_PRODUCERS];
		for (int i = 0; i < NUM_PRODUCERS; i++) {
			producers[i] = cp.new Producer("P " + i, bq);
		}
		
		for (Consumer c : consumers) {
			service.submit(c);
		}
		
		for (Producer p : producers) {
			service.submit(p);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.shutdownNow();
	}
}
