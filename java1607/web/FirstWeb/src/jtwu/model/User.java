package jtwu.model;

// user model depends on the underline database representation
// i am not sure whether this is good
public class User {

	// rep invar
	// status : 1, 2, 3
	
	//状态为0，表示正在等待审核，登录失败
	//状态为1，表示审核通过，登录成功
	//状态为2，表示审核被拒绝，登录失败
	public static int ERR_PENDING_AUTH = 0;
	public static int AUTH_SUCC = 1;
	public static int ERR_AUTH_REJECT = 2;
	
	int id;
	String name;
	String pass;
	int status;
	
	// return an sql VALUES() represent this object
	public String toValues() {
		return "insert into users VALUES (" +
				id + "," +
				"'" + name + "'," +
				"'" + pass + "'," +
				status +
				")";
	}
	
	public static String createStatement() {
		return "create table users (" +
				"id int primary key AUTO_INCREMENT," +
				"name varchar(32)," +
				"pass varchar(32)," +
				"status int" +
				");";
	}
	
	public User(int id, String name, String pass, int status) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPass() {
		return pass;
	}
	
	public User(String name, String pass, int status) {
		super();
		this.name = name;
		this.pass = pass;
		this.status = status;
	}
}
