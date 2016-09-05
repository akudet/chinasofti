package jtwu.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jtwu.controller.service.CookiesService;
import jtwu.controller.service.LoginService;
import jtwu.controller.service.UsersService;
import jtwu.model.User;

public class LoginServlet extends HttpServlet {
	
	// this should be consistent with web.xml file
	public static final String SERVLET_URL = "/LoginServlet";

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LoginService service = new LoginService();
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		int res = service.login(username, userpass);
		System.out.println(username + userpass);
		if (res == LoginService.AUTH_SUCC) {
			ServletContext sc = getServletContext();
			Integer count = (Integer) sc.getAttribute("count");
			if (null != count) {//through it's should not be wrong unless sb do it wrong
				count++;
			}
			sc.setAttribute("count", count);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", new UsersService().findUserByName(username));
		} else {
			request.setAttribute("err_msg", service.getErrMsg(res));
		}
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher(UsersServlet.CONTENT_URL + "user.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher(UsersServlet.CONTENT_URL + "login.jsp").forward(request, response);
		}
	}

}
