package struts2demo.controller;

import com.opensymphony.xwork2.ActionSupport;


public class MsgAction extends ActionSupport {
	
	String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(msg);
		if ("".equals(msg)) {
			return ERROR;
		}
		return SUCCESS;
	}

}
