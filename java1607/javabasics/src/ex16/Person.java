package ex16;

/**
 * a real world person
 * 
 * @author Jintong Wu
 *
 */
public class Person {
	// rep invar
	// String : name
	// Sex : int
	// name should be a valid name
	// int can only be the two constan (MALE, FEMALE)
	
	// thread safe argument
	// using synchronized keyword so setting only got one thread
	// and both field is Immutable
	
	public static final int MALE = 0;
	public static final int FEMALE = 0;
	
	String name;
	int sex;
	public String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public synchronized void setSex(int sex) {
		this.sex = sex;
	}
}
