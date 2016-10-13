package demo.controller;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import demo.model.dao.impl.UserDao;
import demo.model.vo.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User mUser = new User();
	private UserDao mUserDao = new UserDao();

	private String mErrMsg;

	public String getErrMsg() {
		return mErrMsg;
	}

	@Override
	public User getModel() {
		return mUser;
	}

	public User getUser() {
		return mUser;
	}

	public Collection<User> getUsers() {
		return mUserDao.findAll("From User");
	}

	public String login() {
		System.out.println(mUser);
		if ("admin".equals(mUser.getName())) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("userId", mUser.getId());
			return index();
		}

		mErrMsg = "登录失败";
		return "login";
	}

	public String logout() {
		return "";
	}
	
	// return an edit page for editing a mUser
	// the mUser to edit can obtains by getUser
	public String edit() {
		System.out.println("EDIT : " + mUser);
		mUser = mUserDao.find(mUser.getId());
		
		return "edit";
	}
	
	// return an page to show users
	public String index() {
		return "index";
	}

	public String put() {
		System.out.println("PUT : " + mUser);
		mUserDao.update(mUser);
		return index();
	}

	public String delete() {
		System.out.println("DELETE : " + mUser);
		mUserDao.delete(mUser);
		return index();
	}

}
