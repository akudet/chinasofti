package test3;

public class Info {
	
	String name;
	String sex;
	int age;
	public Info(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Info [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}
