package team4.proj2.model.vo;

import javax.persistence.Entity;

@Entity
public class User extends ValueObject {

	private String name;
	private int age;

	public User() {
		super();
	}

	public int getAge() {
		return age;
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
		return "User [name=" + name + ", age=" + age + "]";
	}

}
