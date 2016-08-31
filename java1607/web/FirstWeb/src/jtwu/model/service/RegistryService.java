package jtwu.model.service;

import jtwu.model.User;
import jtwu.model.dao.UserDao;

public class RegistryService {
	
	public static final int REGISTRY_SUCC = 0;
	public static final int REGISTRY_FAIL = 1;

	public int registry(String name, String pass) {
		User user = new User(name, pass, User.AUTH_SUCC);
		
		UserDao dao = new UserDao();
		int res = dao.add(user);
		if (res == 0) {
			return REGISTRY_SUCC;
		}
		return REGISTRY_FAIL;
	}
}
