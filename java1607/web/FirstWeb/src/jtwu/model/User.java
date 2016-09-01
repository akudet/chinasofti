package jtwu.model;

import java.sql.Connection;
import java.sql.SQLException;

// user model depends on the underline database representation
// i am not sure whether this is good
public class User {

	private static final String[] STATUS_DESCRIPTIONS = {
		"等待审核",
		"审核通过",
		"审核拒绝"
	};
	
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
	
	public void saveToDB(Connection conn) throws SQLException {
		conn.prepareStatement(toValues()).execute();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getStatusDescription() {
		return STATUS_DESCRIPTIONS[status];
	}
}
