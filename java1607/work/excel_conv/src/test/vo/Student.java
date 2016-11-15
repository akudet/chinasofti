package test.vo;

import java.util.Date;

public class Student {

	private long stu_id;
	private String name;
	private int age;
	private Date birth;

	public Student() {
		super();
	}

	public Student(long stu_id, String name, int age, Date birth) {
		super();
		this.stu_id = stu_id;
		this.name = name;
		this.age = age;
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public Date getBirth() {
		return birth;
	}

	public String getName() {
		return name;
	}

	public long getStu_id() {
		return stu_id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStu_id(long stu_id) {
		this.stu_id = stu_id;
	}

	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", name=" + name + ", age=" + age
				+ ", birth=" + birth + "]";
	}

}
