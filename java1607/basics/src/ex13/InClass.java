package ex13;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class InClass {
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	/**
	 * ��дѧ���࣬����һ��properties�ļ�����ѧ�������Ϣ���Ӧ�Ĵ洢���ļ��С�
	 * ��ȡ�ļ���Ϣ������ѧ�����󣬲���ѧ������洢�ڼ����С�
	 */
	private static void test5() {
		final String PRO_PATH = "src/ex13/";
		
		File students_f = new File(PRO_PATH + "students.properties");
		
		List<Student> students = new ArrayList<Student>(10);
		
		Student s1 = new Student(1, "jtwu", 22);
		Student s2 = new Student(2, "kyo", 7);
		Student s3 = new Student(3, "izumi", 1);
		Student s4 = new Student(4, "nakato", 16);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		saveStudentsToFile(students_f, students);
		
		// read student from file, and output it
		System.out.println("Properties:");
		Properties s_p = new Properties();
		Set<Student> ss = new HashSet<Student>();
		try {
			s_p.load(new FileInputStream(students_f));
			
			for (Object key : s_p.keySet()) {
				Student s = parse((String) s_p.get(key));
				ss.add(s);
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void saveStudentsToFile(File students_f, Collection<Student> students) {
		Properties students_p = new Properties();
		
		final String comments = "commit by jtwu";
		
		try {
			students_p.load(new FileInputStream(students_f));
			
			for (Student s : students) {
				students_p.setProperty("" + s.getId(), format(s));
			}
			
			students_p.store(new FileOutputStream(students_f), comments);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	private static String format(Student s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.getId());
		sb.append(' ');
		sb.append(s.getName());
		sb.append(' ');
		sb.append(s.getAge());
		return sb.toString();
	}
	
	private static Student parse(String s) {
		Scanner scan = new Scanner(s);
		int id = scan.nextInt();
		String name = scan.next();
		int age = scan.nextInt();
		return new Student(id, name, age);
	}

	/**
	 * ��TreeMap�洢ѧ��������Ϣ������ѧ�������������
	 */
	private static void test4() {
		TreeMap<Student, String> students = new TreeMap<Student, String>();
		
		Student s1 = new Student(1, "jtwu", 22);
		Student s2 = new Student(2, "kyo", 7);
		Student s3 = new Student(3, "izumi", 1);
		Student s4 = new Student(4, "nakato", 16);
		
		students.put(s1, s1.getName());
		students.put(s2, s2.getName());
		students.put(s3, s3.getName());
		students.put(s4, s4.getName());
		
		System.out.println("TreeMap:");
		for (Entry<Student, String> entry : students.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	/**
	 * ��дѧ���࣬ �������н����ѧ�������HashMap�����У�keyֵ��int���洢
	 * ��ͬintֵ���洢��ͬѧ�����鿴�����еĶ�����֤HashMap�Ĵ洢�� 
	 */
	private static void test3() {
		HashMap<Integer, Student> students = new HashMap<Integer, Student>();
		
		Student s1 = new Student(1, "jtwu", 22);
		Student s2 = new Student(2, "kyo", 17);
		Student s3 = new Student(3, "izumi", 17);
		Student s4 = new Student(4, "nakato", 16);
		
		students.put(s1.getId(), s1);
		students.put(s2.getId(), s2);
		students.put(s3.getId(), s3);
		students.put(s4.getId(), s4);
		
		System.out.println("HashMap:");
		for (Entry<Integer, Student> entry : students.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	/**
	 * ��TreeSet�洢�˶��󣬰����˵����佫��������洢��
	 */
	private static void test2() {
		Person p1 = new Person("jtwu", 22);
		Person p2 = new Person("mjg", 21);
		Person p11 = new Person("jtwu", 25);
		
		TreeSet<Person> ts = new TreeSet<Person>();
		ts.add(p11);
		ts.add(p1);
		ts.add(p2);
		
		System.out.println("TreeSet:");
		print(ts);
	}

	/**
	 * HashSet�洢���󡣱�д���ࡣ
	 * ʵ������ͬ��Ϣ���˶��󣬴��뵽�����У���ͬ��Ϣ�Ķ������ظ����롣
	 */
	private static void test1() {
		Person p1 = new Person("jtwu", 22);
		Person p2 = new Person("mjg", 21);
		Person p11 = new Person("jtwu", 22);
		
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(p11);
		hs.add(p1);
		hs.add(p2);
		
		System.out.println("HashSet:");
		print(hs);
	}

	private static void print(Collection<Person> c) {
		for (Person p : c) {
			System.out.println(p);
		}
	}
	
}
