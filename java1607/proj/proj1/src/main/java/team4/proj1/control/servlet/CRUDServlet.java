package team4.proj1.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 巫金桐
 *
 */
public class CRUDServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		System.out.println(req.getPathInfo());
		String pathInfo = req.getPathInfo();
		if (null == pathInfo || pathInfo.equals("/")) {
			if (req.getParameter("GET") != null) {
				doGet(req, resp);
			} else if (req.getParameter("POST") != null) {
				doPost(req, resp);
			} else if (req.getParameter("PUT") != null) {
				doPut(req, resp);
			} else if (req.getParameter("DELETE") != null) {
				doDelete(req, resp);
			} else {
				super.service(req, resp);
			}
		} else if (pathInfo.equals("/edit")) {
			getEdit(req, resp);
		} else if (pathInfo.equals("/new")) {
			getNew(req, resp);
		} else {
			super.service(req, resp);
		}
	}
	
	public void getNew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	public void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
