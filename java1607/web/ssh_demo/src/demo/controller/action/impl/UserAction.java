package demo.controller.action.impl;

import java.util.*;

import org.apache.struts2.ServletActionContext;

import demo.model.vo.User;

public class UserAction extends AbstractCRUDAction<User> {
	
	private String mErrMsg;

	public UserAction() {
		super(User.class);
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
		User user = getModel();
		if ("admin".equals(user.getName())) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("userId", user.getId());
			return "index";
		}

		mErrMsg = "登录失败";
		return "login";
	}

	public String logout() {
		return "";
	}

}
