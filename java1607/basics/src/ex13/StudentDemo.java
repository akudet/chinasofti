package ex13;

import java.util.*;

public class StudentDemo {
	
	public static void main(String... args) {
		HashMap<Student, Integer> hm = new HashMap<Student, Integer>();
		
		hm.put(new Student("123", "jtwu", 22),  1);
		hm.put(new Student("125", "narukami", 32), 4);
		hm.put(new Student("124", "zaft", 22), 4);
		
		hm.put(new Student("222", "wataru", 111), 2);
		
		Student s1 = new Student("123", "jtwu", 22);
		Student s2 = new Student("124", "zaft", 22);
		
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(s1);
		ts.add(s2);
		System.out.println("set size : " + ts.size());
		
		System.out.println(hm.size());
		
		for (Student key : hm.keySet()) {
			System.out.println(key.getName());
		}
		
		TreeMap<Student, Integer> tm = new TreeMap<Student, Integer>(hm);
		
		for (Student key : tm.keySet()) {
			System.out.println(key);
		}
	}

}
