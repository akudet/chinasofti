package test;

import java.util.Date;

public class Student {

	private long stu_id;
	public Student(long stu_id, String name, int age, Date birth) {
		super();
		this.stu_id = stu_id;
		this.name = name;
		this.age = age;
		this.birth = birth;
	}
	private String name;
	private int age;
	private Date birth;
	
}
