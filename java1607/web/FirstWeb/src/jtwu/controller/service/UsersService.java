package jtwu.controller.service;

import java.util.*;

import jtwu.model.User;
import jtwu.model.dao.UserDao;

public class UsersService {

	public Collection<User> getUsers() {
		UserDao dao = new UserDao();
		return dao.getUsers();
	}
}
