package ex13;

public class Student implements Comparable<Student> {
	private int id;
	
	private String name;

	private int age;
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Student o) {
		int res = this.age - o.age;
		if (res == 0) {
			return new Integer(id).compareTo(o.id);
		}
		return res;
	}
	
	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " : ");
		sb.append(age);
		return sb.toString();
	}

}
