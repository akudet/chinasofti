package inclass_15;

import java.util.*;

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
		// TODO Auto-generated method stub
		
	}

	/**
	 * ��TreeMap�洢ѧ��������Ϣ������ѧ�������������
	 */
	private static void test4() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ��дѧ���࣬ �������н����ѧ�������HashMap�����У�keyֵ��int���洢
	 * ��ͬintֵ���洢��ͬѧ�����鿴�����еĶ�����֤HashMap�Ĵ洢�� 
	 */
	private static void test3() {
		// TODO Auto-generated method stub
		
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
