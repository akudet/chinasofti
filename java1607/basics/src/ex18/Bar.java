package ex18;

public class Bar {

	// fields 
	public static int a;
	public static int b;
	public int c;
	
	
	// methods
	
	static void a() {
		a = b;
	}

	void b() {
		b = c;
	}
	
	void c() {
		c = a;
	}
	
	// constructor

	Bar(int x) {
		a = x;
		b = 2;
		c = 3;
	}
	
}
