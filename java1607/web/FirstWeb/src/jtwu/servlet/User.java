package jtwu.servlet;

public class User {

	String name;
	String pass;
	
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
	
	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
}
