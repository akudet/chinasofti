package demo.controller.action.impl;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import demo.controller.service.impl.UserServiceImpl;
import demo.model.vo.User;

public class UserAction extends AbstractCRUDAction<User> {
	
	private String mErrMsg;
	private UserServiceImpl service;

	public UserAction() {
		super(User.class);
		service = new UserServiceImpl();
	}

	public String getErrMsg() {
		return mErrMsg;
	}

	public User getUser() {
		return getModel();
	}

	public Collection<User> getUsers() {
		return getModels();
	}

	public String login() {
		String name = getModel().getName();
		if (null != name) {
			User user = service.login(name, "123");
			if (null != user) {
				ServletActionContext.getRequest().getSession()
						.setAttribute("userId", user.getId());
				return "index";
			}
		}


		mErrMsg = "登录失败";
		return "login";
	}

	public String logout() {
		return "";
	}

}
