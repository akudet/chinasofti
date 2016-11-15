package jtwu.controller.service;

import java.util.Collection;

import jtwu.model.User;
import jtwu.model.dao.UserDao;


// finally I do sth like moogose model
// when I try to implement the UpdateUserService
// I am considering how should I do the update
// it's clear that I need a service to provice some logic
// to update user, the first one I choose is updateUser(oldname, newname)
// i feel sth bad because I talk a user using oldname, which I don't think
// it's good, so how the only ok-way I think is by user object, but
// how, I create one in the servlet and pass it to service ?
// maybe ok, but it need to be consistent with the object create by DAO class
// which mean it depends on DAO, but it should not, since the service class
// should hide the use of DAO away.
// so this service to let servlet not depend on DAO
// but when I try to think it's shape. I feel it's just like moogose model
// and it's much like a dao.Though I call it a service.
// what if I want the business logic to support all DAO operation(in express power)
// em. all a DAO can do. plus some additional features.
// what's the point of the service layer and the DAO layer.
// the situation is not like this,
// instead the business logic is completely depends on the service function.
// if I write this UserService. We can reduce other services's dependencies
// by let them depend on this service.

// # conclusion: we can let our service to behave better(less dependencies) by provide
// a service to wrap the DAO class function,

// # problem: I still don't know how this is compared to moogose model.
// I not sure the similarity and difference between them.

// so it's the problem of MVC architect vs this kind architect

public class UsersService {
	UserDao dao;
	
	public UsersService() {
		super();
		this.dao = new UserDao();
	}

	public int add(User user) {
		return dao.add(user);
	}

	// static is better ? they never use static
	public User findUserByName(String name) {
		return dao.findUserByName(name);
	}
	
	// return true if exists a user named name
	public boolean existsUser(String name) {
		return (null != findUserByName(name));
	}
	
	public int updateUser(User user) {
		return dao.updateUser(user);
	}
	
	public int deleteUser(User user) {
		return dao.deleteUser(user);
	}
	
	public User findUserById(int id) {
		return dao.findUserById(id);
	}
	
	public Collection<User> getUsers() {
		UserDao dao = new UserDao();
		return dao.getUsers();
	}
}
