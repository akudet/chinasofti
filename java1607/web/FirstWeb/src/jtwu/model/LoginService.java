package jtwu.model;

import java.util.HashMap;
import java.util.Map;

import jtwu.model.dao.UserDao;

public class LoginService {
	
	/*
	 * if username and user pass match return AUTH_SUCC
	 * otherwise return err code
	 * you can get the err msg by getErrMsg(errCode)
	 */
	public int login(String username, String userpass) {
		User user = UserDao.findUserByName(username);
		if (null == user) {
			return ERR_NAME_OR_PASS;
		} else {
			int status = user.getStatus();
			System.out.println(status);
			if (status == User.AUTH_SUCC) {
				if (user.getPass().equals(userpass)) {
					return AUTH_SUCC;
				} else {
					return ERR_NAME_OR_PASS;
				}
			} else {
				if (status == User.ERR_PENDING_AUTH) {
					return ERR_PENDING_AUTH;
				} else if (status == User.ERR_AUTH_REJECT) {
					return ERR_AUTH_REJECT;
				}
			}
		}
		
		// not reach here
		return -1;
	}
	
	// not my design required
	//返回1，登录成功
	//返回0，登录失败，等待审核
	//返回2，登录失败，审核被拒绝
	//返回3：登录失败，用户名或密码出错
	public static int AUTH_SUCC = 1;
	public static int ERR_PENDING_AUTH = 0;
	public static int ERR_AUTH_REJECT = 2;
	public static int ERR_NAME_OR_PASS = 3;
	private static Map<Integer, String> ERR_MSG;

	static {
		ERR_MSG = new HashMap<Integer, String>();
		ERR_MSG.put(AUTH_SUCC, "登录成功");
		ERR_MSG.put(ERR_PENDING_AUTH, "登录失败，等待审核");
		ERR_MSG.put(ERR_AUTH_REJECT, "登录失败，审核被拒绝");
		ERR_MSG.put(ERR_NAME_OR_PASS, "登录失败，用户名或密码出错");
	}

	/**
	 * return the error msg of the errCode 
	 * @param errCode
	 * @return
	 */
	public static String getErrMsg(int errCode) {
		return ERR_MSG.get(errCode);
	}
}
