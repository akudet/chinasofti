package exam4.singleton;

public class HelloSingleton {
	
	private static final HelloSingleton INSTANCE = new HelloSingleton();
	
	private static HelloSingleton lazy_instance = null;
	
	private HelloSingleton() {
		
	}
	
	public static HelloSingleton getInstance() {
		return INSTANCE;
	}
	
	public static HelloSingleton getInstanceLazy() {
		if (null == lazy_instance) {
			synchronized (HelloSingleton.class) {
				if (null == lazy_instance) {
					lazy_instance = new HelloSingleton();
				}
			}
		}
		return INSTANCE;
	}

}
