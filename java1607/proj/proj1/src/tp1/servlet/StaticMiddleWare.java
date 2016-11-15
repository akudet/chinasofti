package tp1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticMiddleWare implements MiddleWare {
	
	public final String mRoot;
	
	public StaticMiddleWare(String root) {
		mRoot = root;
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getRequestURL());
		
		String path = req.getPathInfo();
		if (null == path) {
			path = "/";
		}
		
		System.out.println(path);
		req.getRequestDispatcher(mRoot + path).forward(req, resp);
	}

}
