package jtwu.model;

public class User {

	// rep invar
	// status : 1, 2, 3
	
	//状态为0，表示正在等待审核，登录失败
	//状态为1，表示审核通过，登录成功
	//状态为2，表示审核被拒绝，登录失败
	public static int ERR_PENDING_AUTH = 0;
	public static int AUTH_SUCC = 1;
	public static int ERR_AUTH_REJECT = 2;
	
	String name;
	String pass;
	int status;
	
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
