package inclass_15;

public class Student implements Comparable<Student> {
	private int id;
	
	private String name;

	private int age;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student o) {
		int res = new Integer(this.age).compareTo(o.age);
		if (0 == res) {
			res = this.name.compareTo(o.name);
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
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
