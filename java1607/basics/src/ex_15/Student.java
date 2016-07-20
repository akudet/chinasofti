package ex_15;

public class Student implements Comparable<Student> {
	@Override
	public int compareTo(Student o) {
		int res = this.age - o.age;
		if (res == 0) {
			return id.compareTo(o.id);
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

	private String id;
	private String name;
	private int age;
	
	public Student(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
