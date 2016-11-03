package demo.controller.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthenticaitonInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
		if (null != userId) {
			return invocation.invoke();
		}
		
		return invocation.invoke();
//		return "login";
	}

}
