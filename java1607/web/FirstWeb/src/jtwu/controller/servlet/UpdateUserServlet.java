package jtwu.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtwu.controller.service.UserService;
import jtwu.model.User;

public class UpdateUserServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserService();
		
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		int status = Integer.parseInt(request.getParameter("status"));
		
		User user = userService.findUserByName("jtwu");

		user.setName(username);
		user.setPass(userpass);
		user.setStatus(status);
		userService.updateUser(user);
		
		response.sendRedirect("UsersServlet");
	}

}
