package ex18;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexDemo {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
//		Class c = Class.forName("ex18.Bar");
		
		Class c = Bar.class;
		System.out.println(c.getPackage());
		
		
		Method[] ms = c.getDeclaredMethods();
		Constructor cc = c.getDeclaredConstructor(int.class);
		
		Bar b = (Bar) cc.newInstance(123);
		System.out.println(b.a);
		
		for (Method m : ms) {
			System.out.println(m);
			m.invoke(b, null);
			System.out.println(b.b);
		}
	}
	
}
