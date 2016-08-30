package jtwu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtwu.model.LoginService;
import jtwu.model.User;

public class LoginServlet extends HttpServlet {

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

		LoginService service = new LoginService();
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		int res = service.login(username, userpass);
		System.out.println(username + userpass);
		if (res == LoginService.AUTH_SUCC) {
			request.getRequestDispatcher("succ.jsp").forward(request, response);
		} else {
			request.setAttribute("err_msg", service.getErrMsg(res));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
