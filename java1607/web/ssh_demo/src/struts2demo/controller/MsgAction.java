package struts2demo.controller;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class MsgAction extends ActionSupport {
	
	String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String execute() throws Exception {
		ServletActionContext sac;
		
		System.out.println(msg);
		if ("".equals(msg)) {
			return "er";
		}
		return "sc";
	}

}
