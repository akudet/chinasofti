package inclass_15;

public class Student implements Comparable<Student> {
	@Override
	public int compareTo(Student o) {
		int res = this.age - o.age;
		if (res == 0) {
			return this.name.compareTo(o.name);
		}
		return res;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " : ");
		sb.append(age);
		return sb.toString();
	}

	private int id;
	private String name;
	private int age;
	
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
