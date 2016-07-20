package ex_15;

import java.util.*;

public class StudentDemo {
	
	public static void main(String... args) {
		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();
		
		hm.put(1, new Student("123", "jtwu"));
		hm.put(2, new Student("124", "zaft"));
		hm.put(3, new Student("125", "narukami"));
		
		hm.put(1, new Student("222", "wataru"));
		
		System.out.println(hm.size());
		
		
		
	}

}
